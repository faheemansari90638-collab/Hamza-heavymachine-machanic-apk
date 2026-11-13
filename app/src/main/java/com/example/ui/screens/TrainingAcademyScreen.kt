package com.example.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
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
import com.example.data.JcbTrainingDatabase
import com.example.model.AppLanguage
import com.example.model.TrainingLesson
import com.example.model.TrainingLevel
import com.example.model.tr
import com.example.ui.theme.JcbYellow

@Composable
fun TrainingAcademyScreen(
    language: AppLanguage,
    onSelectLesson: (TrainingLesson) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("training_academy_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, JcbYellow.copy(alpha = 0.5f), RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.School,
                            contentDescription = null,
                            tint = JcbYellow,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = tr(
                                    language,
                                    "JCB Mechanic Academy",
                                    "जेसीबी मैकेनिक एकेडमी",
                                    "أكاديمية ميكانيكي JCB"
                                ),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = tr(
                                    language,
                                    "Operator & Technician Training Modules",
                                    "शुरुआती एवं अनुभवी ऑपरेटरों के लिए ट्रेनिंग",
                                    "دروس تدريبية للمبتدئين والمحترفين"
                                ),
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = tr(
                            language,
                            "Master daily machine inspections, 32 greasing points, 500-hour oil services, and safety protocols with complete offline voice tutorials.",
                            "दैनिक निरीक्षण, ग्रीसिंग के 32 पॉइंट्स, इंजन ऑयल और फिल्टर बदलना तथा सुरक्षा सावधानियां 100% ऑफलाइन ऑडियो व चित्रों के साथ सीखें।",
                            "أتقن الفحص اليومي للمعدة، نقاط التشحيم الـ 32، خدمة الزيوت والفلاتر، وبروتوكولات السلامة مع شروحات صوتية تعمل بدون إنترنت."
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        items(JcbTrainingDatabase.lessons, key = { it.id }) { lesson ->
            val levelBadgeColor = when (lesson.level) {
                TrainingLevel.BEGINNER_OPERATOR -> Color(0xFF4CAF50)
                TrainingLevel.INTERMEDIATE_TECHNICIAN -> Color(0xFF00B0FF)
                TrainingLevel.EXPERT_OVERHAUL -> Color(0xFFFF9800)
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSelectLesson(lesson) }
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
                    .testTag("lesson_card_${lesson.id}"),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(14.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = levelBadgeColor.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = lesson.category.get(language),
                                color = levelBadgeColor,
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Timer,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${lesson.estimatedMinutes} ${tr(language, "min", "मिनट", "دقيقة")}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = lesson.title.get(language),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "${lesson.steps.size} ${tr(language, "Practical Training Steps", "ट्रेनिंग स्टेप्स", "خطوات عملية")} • ${tr(language, "Voice Audio Ready", "वॉइस गाइड उपलब्ध", "الشرح الصوتي متاح")}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                                contentDescription = null,
                                tint = JcbYellow,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = tr(language, "Audio Tutorial", "ऑडियो गाइड", "درس صوتي"),
                                fontSize = 12.sp,
                                color = JcbYellow,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        FilledTonalButton(
                            onClick = { onSelectLesson(lesson) },
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                            modifier = Modifier.height(34.dp)
                        ) {
                            Text(
                                text = tr(language, "Start Lesson", "शुरू करें", "ابدأ الدرس"),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}
