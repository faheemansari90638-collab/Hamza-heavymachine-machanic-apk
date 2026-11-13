package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.JcbPart
import com.example.model.tr
import com.example.ui.components.FullScreenPartImageDialog
import com.example.ui.components.LabeledDiagramView
import com.example.ui.components.OfficialManualCallout
import com.example.ui.components.PartStudioPhotoCard
import com.example.ui.components.VoiceExplanationButton
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PartDetailScreen(
    part: JcbPart,
    language: AppLanguage,
    isBookmarked: Boolean,
    onToggleBookmark: () -> Unit,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var showFullScreenImage by remember { mutableStateOf(false) }

    val voiceSummary = when (language) {
        AppLanguage.ENGLISH ->
            "${part.nameEn}. Part Number ${part.partNumber}. Working principle: ${part.workingPrinciple.en}. Damage symptoms: ${part.damageSymptoms.firstOrNull()?.en ?: ""}. Repair instructions: ${part.repairInstructions.firstOrNull()?.en ?: ""}"
        AppLanguage.HINDI ->
            "${part.nameHi}। पार्ट नंबर ${part.partNumber}। कार्य सिद्धांत: ${part.workingPrinciple.hi}। खराबी के लक्षण: ${part.damageSymptoms.firstOrNull()?.hi ?: ""}। रिपेयर सावधानियां: ${part.repairInstructions.firstOrNull()?.hi ?: ""}"
        AppLanguage.ARABIC ->
            "${part.nameAr} (${part.nameEn}). رقم القطعة ${part.partNumber}. مبدأ العمل: ${part.workingPrinciple.get(AppLanguage.ARABIC)}. أعراض العطل: ${part.damageSymptoms.firstOrNull()?.get(AppLanguage.ARABIC) ?: ""}. تعليمات الإصلاح: ${part.repairInstructions.firstOrNull()?.get(AppLanguage.ARABIC) ?: ""}"
    }

    if (showFullScreenImage) {
        FullScreenPartImageDialog(
            imageResId = part.imageResId,
            partNameEn = part.nameEn,
            partNameHi = part.nameHi,
            partNameAr = part.nameAr,
            partNumber = part.partNumber,
            language = language,
            onDismiss = { showFullScreenImage = false }
        )
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("part_detail_screen"),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 1. Dedicated Single-Part White-Background Studio HD Photo Card (Tap to Full-Screen Zoom)
        item {
            PartStudioPhotoCard(
                part = part,
                language = language,
                onOpenFullScreen = { showFullScreenImage = true }
            )
        }

        // 2. Trilingual Header Card (Primary + Remaining Languages + English Technical Term + P/N + Voice)
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
                                text = part.system.title(language),
                                fontWeight = FontWeight.Bold,
                                color = JcbBlack,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }

                        IconButton(
                            onClick = onToggleBookmark,
                            modifier = Modifier
                                .size(48.dp)
                                .testTag("part_detail_bookmark_button")
                        ) {
                            Icon(
                                imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                                contentDescription = tr(language, "Bookmark", "बुकमार्क", "حفظ في المفضلة"),
                                tint = if (isBookmarked) JcbYellow else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = part.name(language),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )

                    // Always keep English technical terminology & other languages cleanly visible
                    Text(
                        text = when (language) {
                            AppLanguage.ENGLISH -> "${part.nameHi}  |  ${part.nameAr}"
                            AppLanguage.HINDI -> "${part.nameEn}  |  ${part.nameAr}"
                            AppLanguage.ARABIC -> "${part.nameEn}  |  ${part.nameHi}"
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Part No: ${part.partNumber}",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = JcbYellow,
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Torque: ${part.torqueSpec.substringBefore('|').trim()}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

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

        // 3. Machine Compatibility & Model-Wise Differences
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Compatible Models & Model Differences",
                    "सपोर्टेड मशीन मॉडल और मॉडल-अनुसार अंतर",
                    "الموديلات المتوافقة والفروقات الفنية"
                ),
                icon = Icons.Default.PrecisionManufacturing,
                iconTint = JcbYellow
            ) {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    part.supportedModels.forEach { modelName ->
                        Surface(
                            color = JcbYellow.copy(alpha = 0.14f),
                            shape = RoundedCornerShape(6.dp),
                            modifier = Modifier.border(
                                1.dp,
                                JcbYellow.copy(alpha = 0.35f),
                                RoundedCornerShape(6.dp)
                            )
                        ) {
                            Text(
                                text = modelName,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = JcbYellow,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }

                if (part.modelDifferences.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        part.modelDifferences.forEach { diff ->
                            Row(verticalAlignment = Alignment.Top) {
                                Text(
                                    text = "• ",
                                    color = JcbYellow,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = diff.get(language),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }
            }
        }

        // 4. Front, Side & Connector / Port Identification Angles
        if (part.viewAngles.isNotEmpty()) {
            item {
                DetailSectionCard(
                    title = tr(
                        language,
                        "Front, Side & Port / Connector Identification",
                        "फ्रंट, साइड और पोर्ट / कनेक्टर पहचान",
                        "تحديد الواجهة الأمامية والجانبية والمنافذ"
                    ),
                    icon = Icons.Default.Visibility,
                    iconTint = Color(0xFF00B0FF)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        part.viewAngles.forEach { angle ->
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        MaterialTheme.colorScheme.surface.copy(alpha = 0.6f),
                                        RoundedCornerShape(8.dp)
                                    )
                                    .padding(10.dp)
                            ) {
                                Text(
                                    text = angle.angleTitle.get(language),
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF00B0FF)
                                )
                                Spacer(modifier = Modifier.height(3.dp))
                                Text(
                                    text = angle.calloutDetail.get(language),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }
            }
        }

        // 5. Labelled Diagram Blueprint Card
        item {
            LabeledDiagramView(
                partName = part.name(language),
                diagramPoints = part.diagramPoints,
                language = language
            )
        }

        // 6. Part Location & Physical Position Card
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Machine Location",
                    "मशीन में स्थान (Part Location)",
                    "موقع القطعة في الآلة"
                ),
                icon = Icons.Default.Place,
                iconTint = Color(0xFF00B0FF)
            ) {
                Text(
                    text = part.location.get(language),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // 7. Working Principle & Function
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Function & Working Principle",
                    "कार्य सिद्धांत एवं कार्यप्रणाली",
                    "الوظيفة ومبدأ العمل"
                ),
                icon = Icons.Default.Settings,
                iconTint = JcbYellow
            ) {
                Text(
                    text = part.workingPrinciple.get(language),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // 8. Safety Warning Box
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFFFF5252).copy(alpha = 0.5f), RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFF5252).copy(alpha = 0.12f)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = tr(language, "Safety Warning", "सुरक्षा चेतावनी", "تحذير سلامة"),
                        tint = Color(0xFFFF5252),
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = part.safetyWarning.get(language),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        // 9. Symptoms of Damage
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Common Faults & Symptoms",
                    "खराबी एवं क्षति के लक्षण (Symptoms of Damage)",
                    "الأعطال الشائعة وأعراض التلف"
                ),
                icon = Icons.Default.ReportProblem,
                iconTint = Color(0xFFFF9800)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    part.damageSymptoms.forEach { symptom ->
                        Row(verticalAlignment = Alignment.Top) {
                            Text(
                                text = "• ",
                                color = Color(0xFFFF9800),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Text(
                                text = symptom.get(language),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }

        // 10. Inspection & Testing Procedure
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Testing & Inspection Procedure",
                    "जांच और टेस्टिंग प्रक्रिया (Inspection & Testing)",
                    "إجراءات الفحص والاختبار"
                ),
                icon = Icons.Default.CheckCircle,
                iconTint = Color(0xFF4CAF50)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    part.inspectionProcedure.forEachIndexed { index, step ->
                        Row(verticalAlignment = Alignment.Top) {
                            Box(
                                modifier = Modifier
                                    .size(22.dp)
                                    .background(Color(0xFF4CAF50).copy(alpha = 0.2f), RoundedCornerShape(4.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${index + 1}",
                                    fontSize = 11.sp,
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

        // 11. Repair & Replacement Instructions
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Repair & Replacement Instructions",
                    "मरम्मत एवं बदलने के निर्देश (Repair & Replacement)",
                    "تعليمات الإصلاح والاستبدال"
                ),
                icon = Icons.Default.Handyman,
                iconTint = JcbYellow
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    part.repairInstructions.forEachIndexed { index, step ->
                        Row(verticalAlignment = Alignment.Top) {
                            Box(
                                modifier = Modifier
                                    .size(22.dp)
                                    .background(JcbYellow.copy(alpha = 0.2f), RoundedCornerShape(4.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${index + 1}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = JcbYellow
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

        // 12. Torque Specifications Box
        item {
            DetailSectionCard(
                title = tr(
                    language,
                    "Torque Specifications",
                    "टॉर्क विशिष्टता (Torque Specifications)",
                    "مواصفات عزم الربط (Torque)"
                ),
                icon = Icons.Default.BuildCircle,
                iconTint = JcbYellow
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    Text(
                        text = part.torqueSpec,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                }
            }
        }

        // 13. Official Service Manual Citation
        item {
            OfficialManualCallout(
                manualText = part.manualReference,
                language = language
            )
        }
    }
}

@Composable
fun DetailSectionCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconTint: Color,
    content: @Composable () -> Unit
) {
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
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconTint,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            content()
        }
    }
}
