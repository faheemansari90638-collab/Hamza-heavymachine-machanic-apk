package com.example.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.JcbMachineModel
import com.example.model.tr
import com.example.ui.components.OfficialManualCallout
import com.example.ui.components.VoiceExplanationButton
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

@Composable
fun MachineDetailScreen(
    machine: JcbMachineModel,
    language: AppLanguage,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val voiceSummary = when (language) {
        AppLanguage.ENGLISH ->
            "${machine.name}. Category: ${machine.category}. Engine specification: ${machine.engineSpec.en}. Operating weight: ${machine.operatingWeight}. Hydraulic pressure: ${machine.hydraulicPressureBar}. Transmission: ${machine.transmissionType.en}. Maintenance schedule: ${machine.maintenanceIntervalHours}."
        AppLanguage.HINDI ->
            "${machine.name}। श्रेणी: ${machine.category}। इंजन क्षमता: ${machine.engineSpec.hi}। ऑपरेटिंग वजन: ${machine.operatingWeight}। हाइड्रोलिक प्रेशर: ${machine.hydraulicPressureBar}। ट्रांसमिशन: ${machine.transmissionType.hi}। सर्विस अंतराल: ${machine.maintenanceIntervalHours}।"
        AppLanguage.ARABIC ->
            "${machine.name}. الفئة: ${machine.category}. المحرك: ${machine.engineSpec.get(AppLanguage.ARABIC)}. الوزن التشغيلي: ${machine.operatingWeight}. الضغط الهيدروليكي: ${machine.hydraulicPressureBar}. ناقل الحركة: ${machine.transmissionType.get(AppLanguage.ARABIC)}. فترات الصيانة: ${machine.maintenanceIntervalHours}."
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("machine_detail_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Machine Hero Card
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, JcbYellow.copy(alpha = 0.5f), RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = JcbYellow,
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = machine.category,
                                fontWeight = FontWeight.Bold,
                                color = JcbBlack,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }

                        Text(
                            text = machine.powerHp,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = JcbYellow
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = machine.name,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = machine.tag(language),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    VoiceExplanationButton(
                        isSpeaking = isSpeaking,
                        onSpeakClick = { onSpeakVoice(voiceSummary) },
                        language = language,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        // Technical Specifications Matrix
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Technical Specifications",
                    "तकनीकी विनिर्देश (Specifications)",
                    "المواصفات الفنية للآلة"
                ),
                icon = Icons.Default.Speed,
                iconTint = JcbYellow
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    SpecRow(
                        label = tr(language, "Engine Specification", "इंजन विवरण", "مواصفات المحرك"),
                        value = machine.engineSpec.get(language)
                    )
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                    SpecRow(
                        label = tr(language, "Operating Weight", "ऑपरेटिंग वजन", "الوزن التشغيلي"),
                        value = machine.operatingWeight
                    )
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                    SpecRow(
                        label = tr(language, "Hydraulic Relief Pressure", "हाइड्रोलिक प्रेशर", "ضغط صمام التنفيس الهيدروليكي"),
                        value = machine.hydraulicPressureBar
                    )
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                    SpecRow(
                        label = tr(language, "Transmission Type", "ट्रांसमिशन प्रकार", "نوع ناقل الحركة"),
                        value = machine.transmissionType.get(language)
                    )
                }
            }
        }

        // Key Features
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Key Technologies & Features",
                    "मुख्य विशेषताएं एवं तकनीक",
                    "أبرز التقنيات والمميزات"
                ),
                icon = Icons.Default.Stars,
                iconTint = Color(0xFFFF9800)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    machine.keyFeatures.forEach { feature ->
                        Row(verticalAlignment = Alignment.Top) {
                            Text(
                                text = "• ",
                                color = JcbYellow,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Text(
                                text = feature.get(language),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }

        // Common Field Applications
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Common Field Applications",
                    "प्रमुख कार्य एवं उपयोग क्षेत्र",
                    "مجالات العمل الميدانية الشائعة"
                ),
                icon = Icons.Default.Handyman,
                iconTint = Color(0xFF00B0FF)
            ) {
                Text(
                    text = machine.commonApplications.get(language),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // Maintenance Schedule Hours
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Preventive Maintenance Schedule",
                    "सर्विस व मेंटेनेंस अंतराल (घंटे)",
                    "جدول الصيانة الوقائية (ساعات التشغيل)"
                ),
                icon = Icons.Default.Schedule,
                iconTint = Color(0xFF4CAF50)
            ) {
                Text(
                    text = machine.maintenanceIntervalHours,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4CAF50)
                )
            }
        }

        // Official Service Manual Citation
        item {
            OfficialManualCallout(
                manualText = machine.manualReference,
                language = language
            )
        }
    }
}

@Composable
fun SpecRow(label: String, value: String) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )
    }
}
