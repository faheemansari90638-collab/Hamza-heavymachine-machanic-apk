package com.example

import com.example.data.JcbAdvancedTechnicalDatabase
import com.example.data.JcbElectricalDatabase
import com.example.data.JcbFaultDatabase
import com.example.data.JcbMachineDatabase
import com.example.data.JcbPartsDatabase
import com.example.data.JcbTrainingDatabase
import com.example.model.AppLanguage
import com.example.model.SystemCategory
import org.junit.Assert.*
import org.junit.Test

class JcbMasterMechanicTest {

    @Test
    fun testElectricalDatabaseIntegrity() {
        assertTrue("Wire colour codes should be cataloged", JcbElectricalDatabase.wireColourCodes.isNotEmpty())
        val redWire = JcbElectricalDatabase.wireColourCodes.firstOrNull { it.code == "R" }
        assertNotNull("Red wire definition must exist", redWire)
        assertEquals(0xFFD32F2F.toLong(), redWire?.hexColor)
        assertTrue("Red wire Arabic translation present", redWire?.baseColour(AppLanguage.ARABIC)?.isNotBlank() == true)

        assertTrue("Harnesses must be populated", JcbElectricalDatabase.wiringHarnesses.isNotEmpty())
        val engineHarness = JcbElectricalDatabase.wiringHarnesses.firstOrNull { it.id == "harness_engine_main" }
        assertNotNull("Engine harness must exist", engineHarness)
        assertTrue("Engine harness must contain wire details", (engineHarness?.wires?.size ?: 0) >= 3)

        assertTrue("Lighting specifications must be populated", JcbElectricalDatabase.machineLights.isNotEmpty())
        val headlights = JcbElectricalDatabase.machineLights.firstOrNull { it.id == "light_headlights_low_high" }
        assertNotNull("Headlights circuit must exist", headlights)
        assertTrue("Headlight must specify positive wire", headlights?.positiveWireColour?.isNotEmpty() == true)

        assertTrue("Fuses must be populated", JcbElectricalDatabase.fuses.isNotEmpty())
        val f1 = JcbElectricalDatabase.fuses.firstOrNull { it.fuseId == "F1" }
        assertNotNull("Fuse F1 must exist", f1)
        assertEquals(10, f1?.ratingAmps)

        assertTrue("Relays must be populated", JcbElectricalDatabase.relays.isNotEmpty())
        val r1 = JcbElectricalDatabase.relays.firstOrNull { it.relayId == "R1" }
        assertNotNull("Relay R1 must exist", r1)

        assertTrue("Sensors must be populated", JcbElectricalDatabase.sensors.isNotEmpty())
        val oilSensor = JcbElectricalDatabase.sensors.firstOrNull { it.id == "sensor_engine_oil_pressure" }
        assertNotNull("Oil pressure sensor must exist", oilSensor)

        assertTrue("Multimeter tutorials must be populated", JcbElectricalDatabase.multimeterTutorials.isNotEmpty())
    }

    @Test
    fun testMachineDatabaseIntegrity() {
        assertTrue("Machines database must contain all required models", JcbMachineDatabase.machines.size >= 8)
        val jcb3cx = JcbMachineDatabase.machines.firstOrNull { it.id == "jcb_3cx" }
        assertNotNull("JCB 3CX must be present", jcb3cx)
        assertTrue("JCB 3CX Arabic tag must not be blank", jcb3cx?.tagArabic?.isNotBlank() == true)
        val jcb3dx = JcbMachineDatabase.machines.firstOrNull { it.id == "jcb_3dx" }
        assertNotNull("JCB 3DX must be present", jcb3dx)
        assertTrue("JCB 3DX Arabic engine spec must not be blank", jcb3dx?.engineSpec?.ar?.isNotBlank() == true)
    }

    @Test
    fun testTrilingualPartsImageLibraryIntegrity() {
        val parts = JcbPartsDatabase.parts
        assertEquals("Parts database must contain all 24 individual parts", 24, parts.size)

        // All 15 system categories must have at least 1 dedicated part
        assertEquals(15, SystemCategory.values().size)
        SystemCategory.values().forEach { category ->
            val categoryParts = JcbPartsDatabase.getByCategory(category)
            assertTrue("Category ${category.name} must have at least one part", categoryParts.isNotEmpty())
        }

        // Strict 1-part-per-image uniqueness & trilingual completeness
        parts.forEach { part ->
            assertTrue("Part ${part.id} English name required", part.nameEn.isNotBlank())
            assertTrue("Part ${part.id} Hindi name required", part.nameHi.isNotBlank())
            assertTrue("Part ${part.id} Arabic name required", part.nameAr.isNotBlank())
            assertTrue("Part ${part.id} Arabic location required", part.location.ar.isNotBlank())
            assertTrue("Part ${part.id} Arabic workingPrinciple required", part.workingPrinciple.ar.isNotBlank())
            assertNotEquals("Part ${part.id} must have dedicated image drawable", 0, part.imageResId)
        }
        assertEquals(
            "Every single part must map to a unique studio photograph (no shared collages)",
            parts.size,
            parts.map { it.imageResId }.distinct().size
        )

        // Verify all 10 required trilingual example mappings
        val requiredExamples = listOf(
            Triple("Hydraulic Pump", "हाइड्रोलिक पंप", "مضخة هيدروليكية"),
            Triple("Starter Motor", "स्टार्टर मोटर", "محرك بادئ التشغيل"),
            Triple("Alternator", "अल्टरनेटर", "المولد الكهربائي"),
            Triple("Radiator", "रेडिएटर", "المُبرِّد"),
            Triple("Fuel Filter", "फ्यूल फिल्टर", "فلتر الوقود"),
            Triple("Battery", "बैटरी", "البطارية"),
            Triple("Engine", "इंजन", "المحرك"),
            Triple("Water Pump", "वॉटर पंप", "مضخة المياه"),
            Triple("Air Filter", "एयर फिल्टर", "فلتر الهواء"),
            Triple("Brake", "ब्रेक", "الفرامل")
        )
        requiredExamples.forEach { (en, hi, ar) ->
            val match = parts.firstOrNull {
                it.nameEn.contains(en, ignoreCase = true) &&
                    it.nameHi.contains(hi) &&
                    it.nameAr.contains(ar)
            }
            assertNotNull("Missing required trilingual part: $en / $hi / $ar", match)
        }
    }

    @Test
    fun testTrilingualPartsSearchAndModelFilter() {
        // English query
        val enSearch = JcbPartsDatabase.searchParts("Starter Motor")
        assertTrue("English search should find Starter Motor", enSearch.any { it.id == "part_starter_motor" })

        // Hindi query
        val hiSearch = JcbPartsDatabase.searchParts("हाइड्रोलिक पंप")
        assertTrue("Hindi search should find Hydraulic Pump", hiSearch.any { it.id == "part_main_hydraulic_pump" })

        // Arabic query
        val arSearch = JcbPartsDatabase.searchParts("مضخة المياه")
        assertTrue("Arabic search should find Water Pump", arSearch.any { it.id == "part_water_pump" })

        // Model filter
        val catParts = JcbPartsDatabase.searchParts(query = "", modelFilter = "CAT")
        assertTrue("CAT model filter should return compatible parts", catParts.isNotEmpty())
        val jcb3cxParts = JcbPartsDatabase.searchParts(query = "", modelFilter = "3CX")
        assertTrue("3CX model filter should return compatible parts", jcb3cxParts.isNotEmpty())
    }

    @Test
    fun testFaultDatabaseIntegrity() {
        assertTrue("Error codes must be populated", JcbFaultDatabase.errorCodes.isNotEmpty())
        assertTrue("Diagnostic guides must be populated", JcbFaultDatabase.diagnosticGuides.isNotEmpty())
        JcbFaultDatabase.errorCodes.forEach { code ->
            assertTrue("Error code ${code.code} must have Arabic title", code.title.ar.isNotBlank())
            assertTrue("Error code ${code.code} must have Arabic symptoms", code.symptoms.ar.isNotBlank())
        }
        JcbFaultDatabase.diagnosticGuides.forEach { guide ->
            assertTrue("Diagnostic guide ${guide.id} must have Arabic title", guide.title.ar.isNotBlank())
        }
    }

    @Test
    fun testTrainingDatabaseIntegrity() {
        assertTrue("Training lessons must be populated", JcbTrainingDatabase.lessons.isNotEmpty())
        JcbTrainingDatabase.lessons.forEach { lesson ->
            assertTrue("Lesson ${lesson.id} must have Arabic title", lesson.title.ar.isNotBlank())
            assertTrue("Lesson ${lesson.id} must have Arabic audio script", lesson.audioScript.ar.isNotBlank())
        }
    }

    @Test
    fun testAdvancedModulesDatabaseIntegrity() {
        assertTrue("Engine overhauls must be populated", JcbAdvancedTechnicalDatabase.engineOverhauls.isNotEmpty())
        val ecomax = JcbAdvancedTechnicalDatabase.engineOverhauls.firstOrNull { it.engineModel.contains("EcoMAX") }
        assertNotNull("EcoMAX overhaul spec must exist", ecomax)
        assertTrue("Head torque stages must be defined", (ecomax?.cylinderHeadTorqueStages?.size ?: 0) >= 3)

        assertTrue("Hydraulic calibrations must be populated", JcbAdvancedTechnicalDatabase.hydraulicCalibrations.isNotEmpty())
        val mrv = JcbAdvancedTechnicalDatabase.hydraulicCalibrations.firstOrNull { it.circuitName.en.contains("Main Relief") }
        assertNotNull("MRV calibration must exist", mrv)
        assertTrue("MRV target pressure must be specified", mrv?.targetPressureBar?.contains("250 bar") == true)

        assertTrue("Drivetrain specs must be populated", JcbAdvancedTechnicalDatabase.drivetrainSpecs.isNotEmpty())
        assertTrue("Dashboard symbols must be populated", JcbAdvancedTechnicalDatabase.dashboardSymbols.isNotEmpty())
        assertTrue("Attachments must be populated", JcbAdvancedTechnicalDatabase.attachments.isNotEmpty())
        assertTrue("Fluids & filters must be populated", JcbAdvancedTechnicalDatabase.fluidsAndFilters.isNotEmpty())
        assertTrue("Calibrations must be populated", JcbAdvancedTechnicalDatabase.calibrations.isNotEmpty())
        assertTrue("Exploded views must be populated", JcbAdvancedTechnicalDatabase.explodedAssemblies.isNotEmpty())
        assertTrue("Video tutorials must be populated", JcbAdvancedTechnicalDatabase.videoTutorials.isNotEmpty())
        assertTrue("Safety protocols must be populated", JcbAdvancedTechnicalDatabase.safetyProtocols.isNotEmpty())
    }
}
