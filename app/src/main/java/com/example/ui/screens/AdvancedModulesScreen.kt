package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.JcbAdvancedTechnicalDatabase
import com.example.model.*
import com.example.ui.components.ExplodedAssemblyDiagramView
import com.example.ui.components.OfficialManualCallout
import com.example.ui.components.VoiceExplanationButton
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedModulesScreen(
    language: AppLanguage,
    selectedModule: MachineModuleType,
    onModuleSelected: (MachineModuleType) -> Unit,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("advanced_modules_screen")
    ) {
        // Search Input
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .testTag("advanced_search_input"),
            placeholder = {
                Text(
                    text = tr(
                        language,
                        "Search engine torque, pressure, oil grade, safety...",
                        "इंजन टॉर्क, हाइड्रोलिक प्रेशर, फ्लूइड, सुरक्षा या डायग्राम खोजें...",
                        "ابحث عن عزم المحرك، الضغط، نوع الزيت، السلامة..."
                    ),
                    fontSize = 12.sp
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = tr(language, "Search", "खोजें", "بحث")
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { onSearchQueryChange("") }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = tr(language, "Clear", "साफ़ करें", "مسح")
                        )
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = JcbYellow,
                cursorColor = JcbYellow
            )
        )

        // Module Filter Pills (Horizontal Scrolling)
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(MachineModuleType.values()) { module ->
                val isSelected = selectedModule == module
                FilterChip(
                    selected = isSelected,
                    onClick = { onModuleSelected(module) },
                    label = {
                        Text(
                            text = module.title(language),
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = JcbYellow,
                        selectedLabelColor = JcbBlack
                    ),
                    modifier = Modifier.testTag("adv_module_tab_${module.id}")
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Content Area by Module
        when (selectedModule) {
            MachineModuleType.ENGINE_OVERHAUL -> {
                EngineOverhaulContent(language = language, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            MachineModuleType.HYDRAULIC_TESTING -> {
                HydraulicTestingContent(language = language, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            MachineModuleType.TRANSMISSION_DRIVETRAIN -> {
                DrivetrainContent(language = language, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            MachineModuleType.DASHBOARD_SYMBOLS -> {
                DashboardSymbolsContent(language = language, searchQuery = searchQuery)
            }
            MachineModuleType.ATTACHMENTS_JOYSTICK -> {
                AttachmentsContent(language = language, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            MachineModuleType.BRAKE_AXLE_STEERING -> {
                BrakesAxlesContent(language = language)
            }
            MachineModuleType.MAINTENANCE_SCHEDULES -> {
                MaintenanceSchedulesContent(language = language)
            }
            MachineModuleType.LUBRICANTS_FILTERS -> {
                FluidsAndFiltersContent(language = language, searchQuery = searchQuery)
            }
            MachineModuleType.DIAGNOSTIC_CALIBRATION -> {
                DiagnosticCalibrationContent(language = language, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            MachineModuleType.MECHANIC_SAFETY -> {
                MechanicSafetyContent(language = language)
            }
            MachineModuleType.EXPLODED_CATALOGUE -> {
                ExplodedCatalogueContent(language = language)
            }
            MachineModuleType.VIDEO_MASTERCLASS -> {
                VideoMasterclassContent(language = language, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 1. ENGINE OVERHAUL & REBUILD
// -------------------------------------------------------------------------------------------------
@Composable
fun EngineOverhaulContent(
    language: AppLanguage,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbAdvancedTechnicalDatabase.engineOverhauls

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { spec ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, JcbYellow.copy(alpha = 0.5f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = spec.engineModel,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Text(
                        text = "${spec.displacementCc} • ${spec.cylinderBoreStroke}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = tr(
                            language,
                            "Cylinder Head Torque Stages:",
                            "सिलेंडर हेड कसने के चरण (Torque Stages):",
                            "مراحل عزم ربط رأس الأسطوانة:"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00B0FF)
                    )
                    spec.cylinderHeadTorqueStages.forEach { stage ->
                        Text("• ${stage.get(language)}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 1.dp))
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${tr(language, "Main Bearing Torque:", "मेन बेयरिंग टॉर्क:", "عزم الكراسي الرئيسية:")} ${spec.mainBearingTorque.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${tr(language, "Big-End Rod Torque:", "कनेक्टिंग रॉड टॉर्क:", "عزم أذرع التوصيل:")} ${spec.bigEndRodTorque.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${tr(language, "Valve Lash (Cold):", "वाल्व टैपेट क्लीयरेंस (ठंडा):", "خلوص الصمامات (بارد):")} ${spec.valveClearanceCold.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF4CAF50),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${tr(language, "Piston Ring End Gap:", "पिस्टन रिंग गैप:", "فجوة شنابر المكبس:")} ${spec.pistonRingGapSpecs.get(language)}",
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = tr(
                            language,
                            "Rebuild & Assembly Steps:",
                            "रीबिल्ड एवं असेंबली के मुख्य कदम:",
                            "خطوات العمرة والتجميع:"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    spec.stepByStepRebuildProcedure.forEach { step ->
                        Text("• ${step.get(language)}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 1.dp))
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    OfficialManualCallout(manualText = spec.manualReference, language = language)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 2. HYDRAULIC PRESSURE TESTING & CALIBRATION
// -------------------------------------------------------------------------------------------------
@Composable
fun HydraulicTestingContent(
    language: AppLanguage,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbAdvancedTechnicalDatabase.hydraulicCalibrations

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { cal ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = cal.circuitName.get(language),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )
                        Surface(
                            color = JcbYellow,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = cal.targetPressureBar,
                                fontWeight = FontWeight.Bold,
                                color = JcbBlack,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "${tr(language, "Port:", "टेस्ट पोर्ट:", "منفذ الفحص:")} ${cal.testPortLocation.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "Gauge Required: ${cal.testGaugeRatingBar}",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF00B0FF)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(
                            language,
                            "Pressure Adjustment Steps:",
                            "प्रेशर एडजस्टमेंट विधि (कदम):",
                            "خطوات ضبط الضغط الهيدروليكي:"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    cal.adjustmentProcedure.forEach { step ->
                        Text("• ${step.get(language)}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 1.dp))
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "${tr(language, "Symptoms If Too High:", "ज्यादा प्रेशर का नुकसान:", "أعراض ارتفاع الضغط المفرط:")} ${cal.symptomsIfHigh.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFFFF5252)
                    )
                    Text(
                        text = "${tr(language, "Symptoms If Too Low:", "कम प्रेशर का नुकसान:", "أعراض انخفاض الضغط:")} ${cal.symptomsIfLow.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFFFF9800)
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 3. GEARBOX, TORQUE CONVERTER & DIFFERENTIAL
// -------------------------------------------------------------------------------------------------
@Composable
fun DrivetrainContent(
    language: AppLanguage,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbAdvancedTechnicalDatabase.drivetrainSpecs

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { d ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = d.systemName.get(language),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Text(
                        text = "Machines: ${d.machineModels.joinToString(", ")}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = d.operatingPrinciple.get(language), style = MaterialTheme.typography.bodySmall)

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Oil: ${d.oilCapacityAndGrade.get(language)}", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
                    Text(text = "Pressures: ${d.linePressuresBar.get(language)}", style = MaterialTheme.typography.bodySmall, color = Color(0xFF00B0FF))
                    Text(text = "Backlash: ${d.differentialCrownPinionBacklash.get(language)}", style = MaterialTheme.typography.bodySmall, color = Color(0xFF4CAF50))

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(
                            language,
                            "Inspection & Rebuild Steps:",
                            "निरीक्षण व ओवरहाल के मुख्य नियम:",
                            "خطوات الفحص والعمرة:"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    d.rebuildAndInspectionSteps.forEach { step ->
                        Text("• ${step.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    OfficialManualCallout(manualText = d.manualReference, language = language)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 4. DASHBOARD SYMBOLS & WARNING LIGHTS
// -------------------------------------------------------------------------------------------------
@Composable
fun DashboardSymbolsContent(
    language: AppLanguage,
    searchQuery: String
) {
    val items = JcbAdvancedTechnicalDatabase.dashboardSymbols.filter {
        val q = searchQuery.trim().lowercase()
        q.isEmpty() ||
                it.nameEn.lowercase().contains(q) ||
                it.nameHi.lowercase().contains(q) ||
                it.nameAr.lowercase().contains(q) ||
                it.underlyingMechanicalCause.en.lowercase().contains(q) ||
                it.underlyingMechanicalCause.ar.lowercase().contains(q)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items) { sym ->
            val toneColor = when (sym.colorTone) {
                SymbolColor.RED_STOP -> Color(0xFFFF5252)
                SymbolColor.AMBER_CAUTION -> Color(0xFFFF9800)
                SymbolColor.BLUE_INFO -> Color(0xFF00B0FF)
                SymbolColor.GREEN_ACTIVE -> Color(0xFF4CAF50)
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, toneColor.copy(alpha = 0.5f), RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                            Text(
                                text = sym.symbolGlyph,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                text = sym.name(language),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Surface(
                            color = toneColor.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = if (sym.isCriticalShutdown)
                                    tr(language, "STOP ENGINE", "इंजन तुरंत बंद करें", "أوقف المحرك فوراً")
                                else
                                    tr(language, "CHECK CAUTION", "सावधानी जांचें", "افحص بحذر"),
                                color = toneColor,
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "${tr(language, "Trigger Condition:", "जलने का कारण:", "سبب الإضاءة:")} ${sym.triggerCondition.get(language)}",
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${tr(language, "Immediate Action:", "ऑपरेटर क्या करे:", "الإجراء الفوري للمشغل:")} ${sym.operatorImmediateAction.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = toneColor
                    )

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${tr(language, "Mechanical Cause:", "अंदरूनी यांत्रिक खराबी:", "السبب الميكانيكي:")} ${sym.underlyingMechanicalCause.get(language)}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 5. ATTACHMENTS, BUCKETS & ROCK BREAKERS
// -------------------------------------------------------------------------------------------------
@Composable
fun AttachmentsContent(
    language: AppLanguage,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbAdvancedTechnicalDatabase.attachments

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { a ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = a.attachmentName.get(language),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Text(
                        text = "Compatible: ${a.compatibleMachines.joinToString(", ")}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Oil Flow: ${a.hydraulicFlowReqLpm}", style = MaterialTheme.typography.bodySmall)
                            Text(text = "Pressure: ${a.operatingPressureBar}", style = MaterialTheme.typography.bodySmall)
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Gas Charge: ${a.nitrogenGasChargeBar}", style = MaterialTheme.typography.bodySmall, color = Color(0xFF00B0FF))
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "${tr(language, "Control Method:", "कंट्रोल तरीका:", "طريقة التحكم:")} ${a.joystickControlMethod.get(language)}",
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(language, "Maintenance Rules:", "मेंटेनेंस व ग्रीसिंग नियम:", "قواعد الصيانة والتشحيم:"),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    a.maintenanceInspection.forEach { m ->
                        Text("• ${m.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = tr(language, "Safety Rules:", "सुरक्षा संचालन निर्देश:", "قواعد التشغيل الآمن:"),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF9800)
                    )
                    a.safetyOperatingRules.forEach { s ->
                        Text("• ${s.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 6. BRAKES, AXLES & STEERING
// -------------------------------------------------------------------------------------------------
@Composable
fun BrakesAxlesContent(language: AppLanguage) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, JcbYellow.copy(alpha = 0.5f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = tr(
                            language,
                            "Rear Axle Oil-Immersed Wet Disc Brakes",
                            "रियर एक्सल वेट डिस्क ब्रेकिंग सिस्टम",
                            "فرامل الأقراص المغمورة بالزيت للمحور الخلفي"
                        ),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = tr(
                            language,
                            "• Fluid Mandate: Use ONLY Light Mineral Hydraulic Oil (ISO VG 15). Never add automotive DOT 3/4 fluid which dissolves internal axle seals.\n• Bleeding: Purge air at both rear trumpet bleed nipples. Pedal must feel firm and not sink to floorplate.",
                            "• हाइड्रोलिक ब्रेक फ्लूइड चेतावनी: केवल मिनरल हाइड्रोलिक ऑयल (ISO VG 15) ही डालें। कभी भी DOT 3/4 ब्रेक ऑयल न डालें नहीं तो एक्सल की सभी रबर सीलें गल जाएंगी।\n• ब्रेक ब्लीडिंग: एक्सल के दोनों सिरों पर लगे ब्लीडर स्क्रू से हवा निकालें। पेडल दबाकर रखने पर फर्श तक नहीं बैठना चाहिए।",
                            "• تحذير السائل: استخدم زيت الفرامل المعدني الخفيف فقط (ISO VG 15). لا تستخدم أبداً زيت DOT 3/4 لأنه يُتلف موانع التسرب الداخلية.\n• تنسيم الهواء: استنزف الهواء من حلمات التنسيم على جانبي المحور الخلفي حتى يصبح الدواسة صلبة."
                        ),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFF00B0FF).copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = tr(
                            language,
                            "4WD Front Steer Axle & Center Pivot",
                            "4WD फ्रंट स्टीयर एक्सल एवं सेंटर पिवट",
                            "محور التوجيه الأمامي للدفع الرباعي ومفصل الارتكاز"
                        ),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00B0FF)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = tr(
                            language,
                            "• Steering Knuckle Kingpins: Grease top and bottom needle bearings every 50 hours.\n• Center Pivot Trunnion: Allows axle oscillation over rough ground; replace thrust washers if axial end-float exceeds 0.6 mm.",
                            "• स्टीयरिंग नकल किंगपिन: ऊपर और नीचे की बेयरिंग में हर 50 घंटे पर ग्रीस भरें।\n• सेंटर पिवट ट्रन्नियन पिन: एक्सल के बीच में लगा पिवट पिन एक्सल को ऊपर-नीचे झूलने देता है; इसका क्लीयरेंस 0.6 mm से ज्यादा होने पर नई थ्रस्ट वाशर डालें।",
                            "• مسامير توجيه المحور (Kingpins): شحّم المحامل العلوية والسفلية كل 50 ساعة تشغيل.\n• مفصل الارتكاز المركزي: يتيح للمحور التأرجح على الأراضي الوعرة؛ استبدل حلقات الدفع إذا تجاوز الخلوص المحوري 0.6 مم."
                        ),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 7. MODEL-SPECIFIC PREVENTIVE MAINTENANCE SCHEDULES
// -------------------------------------------------------------------------------------------------
@Composable
fun MaintenanceSchedulesContent(language: AppLanguage) {
    val schedules = listOf(
        Pair(
            Bilingual(
                "10 / 50 Hours (Daily & Weekly)",
                "10 / 50 घंटे (दैनिक एवं साप्ताहिक सर्विस)",
                "10 / 50 ساعة (الصيانة اليومية والأسبوعية)"
            ),
            listOf(
                Bilingual("Grease all 32 loader and backhoe pins (3% Moly EP grease)", "सभी 32 लोडर और बैकहो पिन में ग्रीस भरें (3% Moly EP ग्रीस)", "شحّم جميع بنوز اللودر والحفار الـ 32 بشحم EP مع 3% موليبدينوم"),
                Bilingual("Check engine oil dipstick & radiator coolant expansion bottle", "इंजन ऑयल गेज और रेडिएटर कूलेंट बोतल चेक करें", "افحص عيار زيت المحرك وقربة سائل تبريد الرديتر"),
                Bilingual("Drain water separator sedimenter bowl under fuel filter", "डीजल फिल्टर के नीचे लगे वाटर सेपरेटर से पानी निकालें", "فرّغ الماء المتجمع من فاصل الديزل أسفل الفلتر"),
                Bilingual("Inspect tyre inflation pressure (Front 38 psi, Rear 30 psi)", "टायर की हवा जांचें (आगे 38 psi, पीछे 30 psi)", "افحص ضغط الإطارات (الأمامي 38 PSI، الخلفي 30 PSI)")
            )
        ),
        Pair(
            Bilingual(
                "500 Hours (Standard Minor Service)",
                "500 घंटे (मानक माइनर सर्विस)",
                "500 ساعة (الصيانة الدورية الصغرى)"
            ),
            listOf(
                Bilingual("Replace engine oil (14.5 Litres 15W-40) and spin-on oil filter", "इंजन ऑयल (14.5L 15W-40) और ऑयल फिल्टर बदलें", "استبدل زيت المحرك (14.5 لتر 15W-40) وفلتر الزيت"),
                Bilingual("Replace primary and secondary fuel filter elements (5-micron)", "प्राइमरी व सेकेंडरी डीजल फिल्टर (5-माइक्रोन) बदलें", "استبدل فلاتر الوقود الأولي والثانوي (5 ميكرون)"),
                Bilingual("Clean or replace hydraulic tank return filter element", "हाइड्रोलिक टैंक रिटर्न फिल्टर साफ करें या बदलें", "نظّف أو استبدل فلتر راجع خزان الهيدروليك"),
                Bilingual("Check fan belt tension (deflection 10-12 mm under thumb load)", "फैन बेल्ट का तनाव चेक करें (दबाव 10-12 mm)", "افحص شد سير المروحة (الارتخاء المسموح 10-12 مم)"),
                Bilingual("Clean radiator and hydraulic oil cooler matrix with compressed air", "प्रेशर हवा से रेडिएटर और ऑयल कूलर साफ करें", "نظّف الرديتر ومبرد الزيت بالهواء المضغوط")
            )
        ),
        Pair(
            Bilingual(
                "1,000 Hours (Major Drivetrain Service)",
                "1,000 घंटे (प्रमुख ड्राइवट्रेन व एक्सल सर्विस)",
                "1,000 ساعة (صيانة ناقل الحركة والمحاور الكبرى)"
            ),
            listOf(
                Bilingual("Drain and replace Synchroshuttle transmission fluid & spin-on filter", "सिंक्रोशटल ट्रांसमिशन ऑयल और फिल्टर बदलें", "استبدل زيت ناقل الحركة Synchroshuttle والفلتر"),
                Bilingual("Drain and replace rear drive axle differential & planetary wheel hub oils", "रियर एक्सल डिफरेंशियल और हब ऑयल बदलें", "استبدل زيت الدفرنس الخلفي وصُرر العجلات الكوكبية"),
                Bilingual("Drain and replace front 4WD steer axle oil and hub gears", "फ्रंट 4WD एक्सल और हब गियर ऑयल बदलें", "استبدل زيت محور الدفع الرباعي الأمامي وصُرره"),
                Bilingual("Adjust engine intake and exhaust valve clearances (tappet setting)", "इंजन वाल्व टैपेट क्लीयरेंस सेट करें", "اضبط خلوص صمامات المحرك (التاكيهات)")
            )
        ),
        Pair(
            Bilingual(
                "2,000 Hours (Full Machine Overhaul Service)",
                "2,000 घंटे (पूर्ण मशीन ओवरहाल सर्विस)",
                "2,000 ساعة (الصيانة الشاملة للنظام الهيدروليكي والتبريد)"
            ),
            listOf(
                Bilingual("Drain completely and replace entire hydraulic reservoir oil (ISO VG 46)", "पूरा हाइड्रोलिक ऑयल (ISO VG 46) बदलें", "فرّغ واستبدل كامل زيت خزان الهيدروليك (ISO VG 46)"),
                Bilingual("Flush engine cooling system and refill genuine 50/50 OAT long-life coolant", "कूलिंग सिस्टम फ्लश करके नया 50/50 OAT कूलेंट भरें", "اغسل دورة التبريد وعبئ سائل تبريد OAT أصلي 50/50"),
                Bilingual("Clean stainless steel hydraulic suction strainer inside tank", "हाइड्रोलिक टैंक के अंदर की सक्शन जाली साफ करें", "نظّف مصفاة الشفط الفولاذية داخل خزان الهيدروليك"),
                Bilingual("Inspect and torque-check all ROPS cabin structural frame bolts", "कैबिन ROPS फ्रेम बोल्ट की जांच व टॉर्क चेक करें", "افحص وشد جميع مسامير هيكل الحماية ROPS للمقصورة")
            )
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(schedules) { (interval, tasks) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = interval.get(language),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    tasks.forEach { task ->
                        Text("• ${task.get(language)}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 2.dp))
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 8. OILS, COOLANTS & FILTER DIRECTORY
// -------------------------------------------------------------------------------------------------
@Composable
fun FluidsAndFiltersContent(
    language: AppLanguage,
    searchQuery: String
) {
    val items = JcbAdvancedTechnicalDatabase.fluidsAndFilters.filter {
        val q = searchQuery.trim().lowercase()
        q.isEmpty() ||
                it.compartment.en.lowercase().contains(q) ||
                it.compartment.hi.lowercase().contains(q) ||
                it.compartment.ar.lowercase().contains(q) ||
                it.recommendedGradeEn.lowercase().contains(q) ||
                it.recommendedGradeAr.lowercase().contains(q) ||
                it.filterPartNumber.lowercase().contains(q)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { f ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = f.compartment.get(language),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = JcbYellow
                        )
                        Surface(
                            color = MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = f.factoryCapacityLiters,
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "${tr(language, "Grade:", "अनुशंसित ग्रेड:", "الدرجة الموصى بها:")} ${f.recommendedGrade(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00B0FF)
                    )
                    Text(
                        text = "JCB Spec: ${f.jcbSpecification}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "${tr(language, "Interval:", "अंतराल:", "فترة التغيير:")} ${f.changeIntervalHours}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF4CAF50),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Filter P/N: ${f.filterPartNumber}",
                        style = MaterialTheme.typography.labelSmall,
                        color = JcbYellow
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = f.contaminationWarnings.get(language),
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFFFF9800)
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 9. ECU SCANNER & CALIBRATION
// -------------------------------------------------------------------------------------------------
@Composable
fun DiagnosticCalibrationContent(
    language: AppLanguage,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbAdvancedTechnicalDatabase.calibrations

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { c ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = c.calibrationName.get(language),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Text(
                        text = "${tr(language, "Models:", "मॉडल:", "الموديلات:")} ${c.supportedModels.joinToString(", ")}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(
                            language,
                            "Prerequisites Before Flashing:",
                            "कैलिब्रेशन शुरू करने से पहले (Prerequisites):",
                            "المتطلبات قبل بدء المعايرة:"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    c.prerequisites.forEach { p ->
                        Text("• ${p.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(
                            language,
                            "Step-by-Step Calibration:",
                            "कदम-दर-कदम प्रोग्रामिंग विधि:",
                            "خطوات المعايرة التدريجية:"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00B0FF)
                    )
                    c.stepByStepProcedure.forEach { s ->
                        Text("• ${s.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "${tr(language, "Confirmation:", "पुष्टि:", "تأكيد النجاح:")} ${c.successConfirmation.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF4CAF50),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    OfficialManualCallout(manualText = c.manualReference, language = language)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 10. MECHANIC & OPERATOR SAFETY
// -------------------------------------------------------------------------------------------------
@Composable
fun MechanicSafetyContent(language: AppLanguage) {
    val items = JcbAdvancedTechnicalDatabase.safetyProtocols

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { p ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color(0xFFFF5252), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = p.topic(language),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF5252)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = p.hazardType.get(language),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(language, "Mandatory Safety Checklist:", "अनिवार्य सुरक्षा चेकलिस्ट:", "قائمة فحص السلامة الإلزامية:"),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4CAF50)
                    )
                    p.mandatoryChecklist.forEach { m ->
                        Text("• ${m.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = tr(language, "Prohibited Actions:", "सख्त मनाही (Prohibited Actions):", "أفعال ممنوعة تماماً:"),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF5252)
                    )
                    p.prohibitedActions.forEach { pr ->
                        Text("• ${pr.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                        color = Color(0xFFFF5252).copy(alpha = 0.12f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "${tr(language, "EMERGENCY:", "आपातकालीन कार्रवाई:", "إجراء الطوارئ:")} ${p.emergencyProcedures.get(language)}",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFFFF5252),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 11. EXPLODED PARTS CATALOGUE
// -------------------------------------------------------------------------------------------------
@Composable
fun ExplodedCatalogueContent(language: AppLanguage) {
    val items = JcbAdvancedTechnicalDatabase.explodedAssemblies

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { assy ->
            ExplodedAssemblyDiagramView(
                title = assy.title(language),
                parts = assy.explodedDiagramNodes,
                language = language
            )
            OfficialManualCallout(manualText = assy.serviceNotes.get(language), language = language)
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 12. VIDEO MASTERCLASS TUTORIALS
// -------------------------------------------------------------------------------------------------
@Composable
fun VideoMasterclassContent(
    language: AppLanguage,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbAdvancedTechnicalDatabase.videoTutorials

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { v ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, JcbYellow.copy(alpha = 0.5f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = v.title(language),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )
                        Surface(
                            color = JcbYellow,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = "${v.durationMin} MIN HD",
                                fontWeight = FontWeight.Bold,
                                color = JcbBlack,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "${tr(language, "Instructor:", "प्रशिक्षक:", "المدرب:")} ${v.presenterInstructor.get(language)}",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF00B0FF)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(
                            language,
                            "Video Masterclass Core Learnings:",
                            "वीडियो के मुख्य सीखने योग्य बिंदु:",
                            "أهم نقاط التعلم في الدرس:"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    v.videoKeyPoints.forEach { pt ->
                        Text("• ${pt.get(language)}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 1.dp))
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = Color(0xFF4CAF50).copy(alpha = 0.15f),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = tr(language, "✓ 100% Offline Cached", "✓ 100% ऑफ़लाइन उपलब्ध", "✓ محفوظ 100% بدون إنترنت"),
                                color = Color(0xFF4CAF50),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }

                        Button(
                            onClick = {
                                val summary = when (language) {
                                    AppLanguage.ENGLISH -> "${v.titleEn}. Key learning: ${v.videoKeyPoints.firstOrNull()?.en ?: ""}"
                                    AppLanguage.HINDI -> "${v.titleHi}। मुख्य बिंदु: ${v.videoKeyPoints.firstOrNull()?.hi ?: ""}"
                                    AppLanguage.ARABIC -> "${v.title(AppLanguage.ARABIC)}. النقطة الرئيسية: ${v.videoKeyPoints.firstOrNull()?.get(AppLanguage.ARABIC) ?: ""}"
                                }
                                onSpeakVoice(summary)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = JcbYellow, contentColor = JcbBlack),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = tr(language, "Play Audio", "ऑडियो सुनें", "تشغيل الصوت"),
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
