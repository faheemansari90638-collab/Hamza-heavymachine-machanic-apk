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
import com.example.model.ErrorSeverity
import com.example.model.JcbErrorCode
import com.example.model.tr
import com.example.ui.components.OfficialManualCallout
import com.example.ui.components.VoiceExplanationButton
import com.example.ui.theme.JcbYellow

@Composable
fun ErrorCodeDetailScreen(
    errorCode: JcbErrorCode,
    language: AppLanguage,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val severityColor = when (errorCode.severity) {
        ErrorSeverity.CRITICAL_STOP -> Color(0xFFFF5252)
        ErrorSeverity.WARNING_CAUTION -> Color(0xFFFF9800)
        ErrorSeverity.MAINTENANCE_ADVISORY -> Color(0xFF00B0FF)
    }

    val voiceScript = when (language) {
        AppLanguage.ENGLISH ->
            "JCB Error Code ${errorCode.code}. ${errorCode.title.en}. Symptoms: ${errorCode.symptoms.en}. Primary cause: ${errorCode.probableCauses.firstOrNull()?.en ?: ""}. Troubleshooting step: ${errorCode.stepByStepTroubleshooting.firstOrNull()?.en ?: ""}"
        AppLanguage.HINDI ->
            "जेसीबी त्रुटि कोड ${errorCode.code}। ${errorCode.title.hi}। लक्षण: ${errorCode.symptoms.hi}। संभावित कारण: ${errorCode.probableCauses.firstOrNull()?.hi ?: ""}। निवारण पहला कदम: ${errorCode.stepByStepTroubleshooting.firstOrNull()?.hi ?: ""}"
        AppLanguage.ARABIC ->
            "رمز عطل JCB ${errorCode.code}. ${errorCode.title.get(AppLanguage.ARABIC)}. الأعراض: ${errorCode.symptoms.get(AppLanguage.ARABIC)}. السبب الرئيسي: ${errorCode.probableCauses.firstOrNull()?.get(AppLanguage.ARABIC) ?: ""}. الخطوة الأولى للإصلاح: ${errorCode.stepByStepTroubleshooting.firstOrNull()?.get(AppLanguage.ARABIC) ?: ""}"
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("error_code_detail_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Error Code Header Card
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, severityColor, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .background(severityColor, RoundedCornerShape(8.dp))
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = errorCode.code,
                                fontWeight = FontWeight.Black,
                                fontSize = 18.sp,
                                color = Color.White
                            )
                        }

                        Surface(
                            color = severityColor.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = if (errorCode.canOperate)
                                    tr(language, "Caution Mode", "सतर्कता से चलाएं", "تشغيل بحذر")
                                else
                                    tr(language, "CRITICAL SHUTDOWN", "मशीन तुरंत बंद करें", "إيقاف حرج فوري"),
                                color = severityColor,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = errorCode.title.get(language),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "${tr(language, "System:", "सिस्टम:", "النظام:")} ${errorCode.system.title(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    VoiceExplanationButton(
                        isSpeaking = isSpeaking,
                        onSpeakClick = { onSpeakVoice(voiceScript) },
                        language = language,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        // Warning Lamp Indicator Box
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Lightbulb,
                        contentDescription = tr(language, "Warning Lamp", "चेतावनी बत्ती", "لمبة التحذير"),
                        tint = severityColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = tr(
                                language,
                                "Dashboard Warning Lamp Type",
                                "डैशबोर्ड चेतावनी बत्ती",
                                "نوع لمبة التحذير في الطبلون"
                            ),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = errorCode.warningLampType,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = severityColor
                        )
                    }
                }
            }
        }

        // Observed Symptoms
        item {
            DetailSectionCard(
                title = tr(language, "Observed Symptoms", "मशीन में दिखने वाले लक्षण", "الأعراض الملاحظة"),
                icon = Icons.Default.Visibility,
                iconTint = JcbYellow
            ) {
                Text(
                    text = errorCode.symptoms.get(language),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // Probable Causes
        item {
            DetailSectionCard(
                title = tr(language, "Probable Root Causes", "संभावित मुख्य कारण", "الأسباب الجذرية المحتملة"),
                icon = Icons.Default.HelpOutline,
                iconTint = Color(0xFFFF9800)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    errorCode.probableCauses.forEach { cause ->
                        Row(verticalAlignment = Alignment.Top) {
                            Text(
                                text = "• ",
                                color = Color(0xFFFF9800),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Text(
                                text = cause.get(language),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }

        // Step-by-Step Troubleshooting Procedure
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Step-by-Step Troubleshooting",
                    "कदम-दर-कदम फॉल्ट निवारण",
                    "خطوات تتبع العطل وإصلاحه"
                ),
                icon = Icons.Default.FactCheck,
                iconTint = Color(0xFF4CAF50)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    errorCode.stepByStepTroubleshooting.forEachIndexed { index, step ->
                        Row(verticalAlignment = Alignment.Top) {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .background(Color(0xFF4CAF50).copy(alpha = 0.2f), RoundedCornerShape(4.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${index + 1}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF4CAF50)
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = step.get(language),
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }

        // Official Service Manual Citation
        item {
            OfficialManualCallout(
                manualText = errorCode.officialManualNote,
                language = language
            )
        }
    }
}
