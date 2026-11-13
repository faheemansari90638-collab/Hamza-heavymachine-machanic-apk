package com.example.ui.screens

import androidx.compose.foundation.background
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
import com.example.model.DiagnosticGuide
import com.example.model.tr
import com.example.ui.components.OfficialManualCallout
import com.example.ui.components.VoiceExplanationButton
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

@Composable
fun DiagnosticDetailScreen(
    guide: DiagnosticGuide,
    language: AppLanguage,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val voiceSummary = when (language) {
        AppLanguage.ENGLISH ->
            "${guide.title.en}. Overview: ${guide.overview.en}. Initial check: ${guide.symptomChecks.firstOrNull()?.procedure?.en ?: ""}"
        AppLanguage.HINDI ->
            "${guide.title.hi}। समस्या विवरण: ${guide.overview.hi}। पहला कदम: ${guide.symptomChecks.firstOrNull()?.procedure?.hi ?: ""}"
        AppLanguage.ARABIC ->
            "${guide.title.get(AppLanguage.ARABIC)}. نظرة عامة: ${guide.overview.get(AppLanguage.ARABIC)}. الفحص الأول: ${guide.symptomChecks.firstOrNull()?.procedure?.get(AppLanguage.ARABIC) ?: ""}"
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("diagnostic_detail_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Guide Header Card
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, JcbYellow.copy(alpha = 0.5f), RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Surface(
                        color = JcbYellow,
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = guide.category,
                            fontWeight = FontWeight.Bold,
                            color = JcbBlack,
                            fontSize = 11.sp,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = guide.title.get(language),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = guide.overview.get(language),
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

        // Common Operator/Mechanic Mistakes Warning Box
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFFFF9800).copy(alpha = 0.5f), RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFF9800).copy(alpha = 0.12f)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = tr(language, "Caution", "सावधानी", "تنبيه"),
                        tint = Color(0xFFFF9800),
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = tr(
                                language,
                                "Common Mechanic Mistakes To Avoid",
                                "सामान्य गलतियों से बचें (चेतावनी)",
                                "أخطاء شائعة يجب تجنبها أثناء الفحص"
                            ),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF9800)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = guide.commonMistakes.get(language),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }

        // Diagnostic Steps List
        item {
            Text(
                text = tr(
                    language,
                    "Diagnostic Steps & Remedies",
                    "जांच प्रक्रिया के चरण",
                    "خطوات الفحص والحلول"
                ),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        guide.symptomChecks.forEach { step ->
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .background(JcbYellow, RoundedCornerShape(6.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${step.stepNumber}",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 13.sp,
                                    color = JcbBlack
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = step.title.get(language),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = tr(language, "Inspection Procedure:", "जांच विधि:", "طريقة الفحص:"),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = JcbYellow
                        )
                        Text(
                            text = step.procedure.get(language),
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = tr(language, "Expected Normal Outcome:", "अपेक्षित सही परिणाम:", "النتيجة السليمة المتوقعة:"),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4CAF50)
                        )
                        Text(
                            text = step.expectedOutcome.get(language),
                            style = MaterialTheme.typography.bodySmall
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = tr(language, "Remedy If Test Fails:", "यदि फेल हो तो उपाय:", "الإجراء في حال فشل الاختبار:"),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF5252)
                        )
                        Text(
                            text = step.remedyIfFailed.get(language),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // Official Manual Citation
        item {
            OfficialManualCallout(
                manualText = guide.manualRef,
                language = language
            )
        }
    }
}
