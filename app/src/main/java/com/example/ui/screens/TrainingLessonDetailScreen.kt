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
import com.example.model.TrainingLesson
import com.example.model.tr
import com.example.ui.components.VoiceExplanationButton
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

@Composable
fun TrainingLessonDetailScreen(
    lesson: TrainingLesson,
    language: AppLanguage,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val fullSpeech = lesson.audioScript.get(language)

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("training_lesson_detail_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Lesson Header Card
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
                                text = lesson.category.get(language),
                                fontWeight = FontWeight.Bold,
                                color = JcbBlack,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }

                        Text(
                            text = "${lesson.estimatedMinutes} ${tr(language, "min", "मिनट", "دقيقة")}",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = JcbYellow
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = lesson.title.get(language),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    VoiceExplanationButton(
                        isSpeaking = isSpeaking,
                        onSpeakClick = { onSpeakVoice(fullSpeech) },
                        language = language,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        // Tools & Materials Required
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Tools & Equipment Required",
                    "आवश्यक औजार एवं सामग्री",
                    "العدد والأدوات المطلوبة"
                ),
                icon = Icons.Default.Construction,
                iconTint = JcbYellow
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    lesson.toolsRequired.forEach { tool ->
                        Row(verticalAlignment = Alignment.Top) {
                            Text(
                                text = "• ",
                                color = JcbYellow,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Text(
                                text = tool.get(language),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }

        // Fluid Capacity or Torque Spec if available
        lesson.fluidCapacitiesOrTorque?.let { spec ->
            item {
                DetailSectionCard(
                    title = tr(
                        language,
                        "Capacities & Torque Values",
                        "ऑयल क्षमता एवं टॉर्क मान",
                        "سعات الزيوت وقيم عزم الربط"
                    ),
                    icon = Icons.Default.OilBarrel,
                    iconTint = Color(0xFF00B0FF)
                ) {
                    Text(
                        text = spec.get(language),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00B0FF)
                    )
                }
            }
        }

        // Safety Checklist Card
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Mandatory Safety Checklist",
                    "सुरक्षा चेकलिस्ट (अनिवार्य)",
                    "قائمة فحص السلامة الإلزامية"
                ),
                icon = Icons.Default.Shield,
                iconTint = Color(0xFF4CAF50)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    lesson.safetyChecklist.forEach { safety ->
                        Row(verticalAlignment = Alignment.Top) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = Color(0xFF4CAF50),
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = safety.get(language),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }

        // Training Procedure Steps
        item {
            Text(
                text = tr(
                    language,
                    "Step-by-Step Practical Training",
                    "प्रैक्टिकल ट्रेनिंग चरण",
                    "خطوات التدريب العملي"
                ),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        lesson.steps.forEach { step ->
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .background(JcbYellow, RoundedCornerShape(6.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${step.stepIndex}",
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
                            text = step.description.get(language),
                            style = MaterialTheme.typography.bodyMedium
                        )

                        step.keyCaution?.let { caution ->
                            Spacer(modifier = Modifier.height(8.dp))
                            Surface(
                                color = Color(0xFFFF9800).copy(alpha = 0.12f),
                                shape = RoundedCornerShape(8.dp),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFFF9800).copy(alpha = 0.4f))
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Info,
                                        contentDescription = null,
                                        tint = Color(0xFFFF9800),
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = caution.get(language),
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color(0xFFFF9800),
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
