package com.example.model

/**
 * Electrical Sub-category navigation
 */
enum class ElectricalCategory(
    val id: String,
    val titleEn: String,
    val titleHi: String,
    val titleAr: String,
    val iconName: String
) {
    HARNESSES("harnesses", "Wiring Harnesses & Loom", "वायरिंग हार्नेस और लूम", "ضفائر الأسلاك الكهربائية", "cable"),
    LIGHTING("lighting", "Lights & Light Cables", "लाइट्स एवं लाइटिंग केबल्स", "الأضواء وكابلات الإنارة", "lightbulb"),
    FUSE_BOX("fuse_box", "Fuse Box System", "फ्यूज बॉक्स और रेटिंग", "صندوق المصهرات (الفيوزات)", "fuse"),
    RELAYS("relays", "Relays & Solenoids", "रिले और सोलेनोइड सिस्टम", "المرحلات والملفات اللولبية", "relay"),
    SENSORS("sensors", "Sensors & ECU Inputs", "इलेक्ट्रिकल सेंसर और ईसीयू", "الحساسات ومدخلات وحدة التحكم", "sensor"),
    SWITCHES("switches", "Switches & Controls", "स्विचेस एवं कंट्रोल लीवर्स", "المفاتيح وأدوات التحكم", "toggle"),
    STARTING_CHARGING("starting_charging", "Battery, Starter & Alternator", "बैटरी, स्टार्टर व अल्टरनेटर", "البطارية والسلف والدينامو", "battery_charging"),
    MULTIMETER_TRAINING("multimeter", "Multimeter Masterclass", "मल्टीमीटर टेस्टिंग ट्रेनिंग", "دورة فحص الملتيميتر", "speed"),
    WIRE_COLOUR_CODES("colour_codes", "Wire Colour Code Library", "वायरिंग कलर कोड डायरेक्टरी", "دليل ألوان الأسلاك", "palette"),
    CONNECTORS_PINOUTS("connectors", "Connectors & Pinouts DB", "कनेक्टर्स एवं पिनआउट डेटाबेस", "الموصلات وترتيب الأطراف", "cable_pin"),
    SCHEMATIC_DIAGRAMS("schematics", "Interactive Schematics", "इंटरएक्टिव सर्किट डायग्राम", "المخططات الكهربائية التفاعلية", "schema");

    fun title(lang: AppLanguage): String = tr(lang, titleEn, titleHi, titleAr)
}

/**
 * Standard or Manufacturer Wiring Colour Specification
 */
data class WireColourCode(
    val code: String,
    val baseColourEn: String,
    val baseColourHi: String,
    val hexColor: Long,
    val stripeHexColor: Long? = null,
    val typicalCircuitEn: String,
    val typicalCircuitHi: String,
    val jcbBritishStandardRuleEn: String,
    val jcbBritishStandardRuleHi: String,
    val baseColourAr: String = "",
    val typicalCircuitAr: String = "",
    val jcbBritishStandardRuleAr: String = ""
) {
    fun baseColour(lang: AppLanguage): String = tr(lang, baseColourEn, baseColourHi, baseColourAr)
    fun typicalCircuit(lang: AppLanguage): String = tr(lang, typicalCircuitEn, typicalCircuitHi, typicalCircuitAr)
    fun rule(lang: AppLanguage): String = tr(lang, jcbBritishStandardRuleEn, jcbBritishStandardRuleHi, jcbBritishStandardRuleAr)
}

/**
 * Detailed Wire Trace Node in a Harness
 */
data class WireDetail(
    val wireId: String,
    val gaugeMm2: String,
    val colourCode: String,
    val hexPrimary: Long,
    val hexStripe: Long? = null,
    val circuitVoltage: String,
    val startLocation: Bilingual,
    val endLocation: Bilingual,
    val connectorPinStart: String,
    val connectorPinEnd: String,
    val purpose: Bilingual,
    val testMethod: Bilingual
)

/**
 * Wiring Harness Assembly Model
 */
data class WiringHarnessModel(
    val id: String,
    val harnessNameEn: String,
    val harnessNameHi: String,
    val machineModels: List<String>,
    val locationDescription: Bilingual,
    val mainConnectors: List<String>,
    val groundPoints: List<Bilingual>,
    val commonFaults: List<Bilingual>,
    val wires: List<WireDetail>,
    val manualReference: String,
    val harnessNameAr: String = ""
) {
    fun name(lang: AppLanguage): String = tr(lang, harnessNameEn, harnessNameHi, harnessNameAr)
}

/**
 * Complete Lighting and Light Cable Specification
 */
data class MachineLight(
    val id: String,
    val nameEn: String,
    val nameHi: String,
    val positionOnMachine: Bilingual,
    val bulbTypeAndWattage: String,
    val operatingVoltage: String,
    val positiveWireColour: String,
    val positiveHex: Long,
    val negativeWireColour: String,
    val negativeHex: Long,
    val switchControl: Bilingual,
    val fuseNumberAndRating: String,
    val relayNumber: String,
    val connectorAndPins: String,
    val testingProcedure: List<Bilingual>,
    val repairSteps: List<Bilingual>,
    val manualReference: String,
    val nameAr: String = ""
) {
    fun name(lang: AppLanguage): String = tr(lang, nameEn, nameHi, nameAr)
}

/**
 * Fuse Specification in Fuse Box
 */
data class FuseSpec(
    val fuseId: String,
    val boxLocation: FuseBoxLocation,
    val ratingAmps: Int,
    val colorStandard: String,
    val protectedCircuitsEn: String,
    val protectedCircuitsHi: String,
    val wireFeedSource: String,
    val blownSymptoms: Bilingual,
    val troubleshootingSteps: List<Bilingual>,
    val warningNote: Bilingual,
    val protectedCircuitsAr: String = ""
) {
    fun protectedCircuits(lang: AppLanguage): String = tr(lang, protectedCircuitsEn, protectedCircuitsHi, protectedCircuitsAr)
}

enum class FuseBoxLocation(val titleEn: String, val titleHi: String, val titleAr: String) {
    MAIN_CABIN("Cabin Main Fuse Console", "कैबिन मेन फ्यूज कंसोल", "لوحة المصهرات الرئيسية بالمقصورة"),
    ENGINE_BAY("Engine Bay High-Current Fusible Box", "इंजन बे हाई-करंट फ्यूज बॉक्स", "صندوق مصهرات التيار العالي بالمحرك"),
    BATTERY_ISOLATOR("Battery Terminal Maxi-Fuse Block", "बैटरी टर्मिनल मैक्सी फ्यूज ब्लॉक", "كتلة المصهرات الكبرى بالبطارية");

    fun title(lang: AppLanguage): String = tr(lang, titleEn, titleHi, titleAr)
}

/**
 * Relay Specification
 */
data class RelaySpec(
    val relayId: String,
    val functionEn: String,
    val functionHi: String,
    val pin85: Bilingual,
    val pin86: Bilingual,
    val pin30: Bilingual,
    val pin87: Bilingual,
    val pin87a: Bilingual? = null,
    val resistanceOhmsCoil: String,
    val testingProcedure: List<Bilingual>,
    val jumperBypassWarning: Bilingual,
    val replacementPartNo: String,
    val manualReference: String,
    val functionAr: String = ""
) {
    fun function(lang: AppLanguage): String = tr(lang, functionEn, functionHi, functionAr)
}

/**
 * Comprehensive Electrical Sensor
 */
data class ElectricalSensorSpec(
    val id: String,
    val sensorNameEn: String,
    val sensorNameHi: String,
    val applicableMachines: List<String>,
    val physicalLocation: Bilingual,
    val connectorTypeAndPins: String,
    val operatingVoltage: String,
    val outputSignalType: Bilingual,
    val pinoutDetails: List<Bilingual>,
    val normalResistanceOrSpecs: String,
    val failureSymptoms: List<Bilingual>,
    val multimeterBenchTesting: List<Bilingual>,
    val manualReference: String,
    val sensorNameAr: String = ""
) {
    fun name(lang: AppLanguage): String = tr(lang, sensorNameEn, sensorNameHi, sensorNameAr)
}

/**
 * Switch and Control Spec
 */
data class SwitchSpec(
    val id: String,
    val switchNameEn: String,
    val switchNameHi: String,
    val location: Bilingual,
    val switchType: String,
    val terminalPinout: List<Bilingual>,
    val normalContinuityTruthTable: List<Bilingual>,
    val testingWithMultimeter: List<Bilingual>,
    val commonFailureModes: List<Bilingual>,
    val manualReference: String,
    val switchNameAr: String = ""
) {
    fun name(lang: AppLanguage): String = tr(lang, switchNameEn, switchNameHi, switchNameAr)
}

/**
 * Multimeter Practical Training Lesson
 */
data class MultimeterTutorial(
    val id: String,
    val titleEn: String,
    val titleHi: String,
    val meterSetting: String,
    val redLeadPort: String,
    val blackLeadPort: String,
    val safetyFirstRule: Bilingual,
    val stepByStepTesting: List<Bilingual>,
    val goodReadingInterpretation: Bilingual,
    val badReadingInterpretation: Bilingual,
    val realJcbExample: Bilingual,
    val titleAr: String = ""
) {
    fun title(lang: AppLanguage): String = tr(lang, titleEn, titleHi, titleAr)
}

/**
 * Connector and Pinout Detailed Profile
 */
data class ConnectorPinout(
    val connectorId: String,
    val typeAndHousing: String,
    val systemAndLoom: Bilingual,
    val matingPartNo: String,
    val pins: List<PinDetail>,
    val probePrecaution: Bilingual
)

data class PinDetail(
    val pinNumber: String,
    val wireColour: String,
    val hexColor: Long,
    val signalFunctionEn: String,
    val signalFunctionHi: String,
    val nominalVoltage: String,
    val testExpectedValue: String,
    val signalFunctionAr: String = ""
) {
    fun signalFunction(lang: AppLanguage): String = tr(lang, signalFunctionEn, signalFunctionHi, signalFunctionAr)
}
