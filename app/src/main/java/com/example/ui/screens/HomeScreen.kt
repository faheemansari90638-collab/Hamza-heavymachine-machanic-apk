package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.JcbMachineDatabase
import com.example.model.AppLanguage
import com.example.model.JcbMachineModel
import com.example.model.SystemCategory
import com.example.model.tr
import com.example.ui.components.OfflineStatusBadge
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

@Composable
fun HomeScreen(
    language: AppLanguage,
    onNavigateToParts: () -> Unit,
    onNavigateToModels: () -> Unit,
    onNavigateToFaults: () -> Unit,
    onNavigateToTraining: () -> Unit,
    onNavigateToElectrical: () -> Unit,
    onNavigateToAdvancedModules: () -> Unit,
    onSelectMachine: (JcbMachineModel) -> Unit,
    onSelectSystem: (SystemCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("home_screen"),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        // Hero Banner with 3D Industrial Machinery Graphic
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.jcb_hero_banner),
                    contentDescription = "JCB Heavy Machinery",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Dark gradient overlay for readable text
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    JcbBlack.copy(alpha = 0.5f),
                                    JcbBlack.copy(alpha = 0.95f)
                                )
                            )
                        )
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                ) {
                    OfflineStatusBadge(language = language)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(
                            language,
                            "JCB MASTER MECHANIC",
                            "जेसीबी मास्टर मैकेनिक",
                            "خبير صيانة JCB الشامل"
                        ),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Black,
                        color = JcbYellow
                    )
                    Text(
                        text = tr(
                            language,
                            "A to Z Trilingual Parts Image Library, Diagnostics, Fault Codes & Training (100% Offline)",
                            "A to Z पार्ट्स फोटो लाइब्रेरी, रिपेयरिंग, फॉल्ट कोड्स और मैकेनिक ट्रेनिंग (100% ऑफलाइन)",
                            "مكتبة صور القطع بـ 3 لغات، التشخيص، أكواد الأعطال والتدريب العملي (100% بدون إنترنت)"
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
        }

        // Quick Access Operational Feature Cards
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                QuickNavCard(
                    title = tr(language, "A-Z Parts Photos", "पार्ट्स फोटो कैटलॉग", "مكتبة صور القطع"),
                    subtitle = tr(language, "15 Systems • HD Zoom", "15 सिस्टम • HD ज़ूम", "15 قسماً • تكبير HD"),
                    icon = Icons.Default.Build,
                    accentColor = JcbYellow,
                    onClick = onNavigateToParts,
                    modifier = Modifier.weight(1f),
                    testTag = "home_quick_parts"
                )
                QuickNavCard(
                    title = tr(language, "Fault Codes", "फॉल्ट कोड्स", "أكواد الأعطال"),
                    subtitle = tr(language, "Diagnostics", "समस्या निवारण", "تشخيص المشاكل"),
                    icon = Icons.Default.Warning,
                    accentColor = Color(0xFFFF5722),
                    onClick = onNavigateToFaults,
                    modifier = Modifier.weight(1f),
                    testTag = "home_quick_faults"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                QuickNavCard(
                    title = tr(language, "Electrical Wiring", "वायरिंग व सर्किट", "الكهرباء والضفائر"),
                    subtitle = tr(language, "Looms, Fuses & Relays", "हार्नेस, लाइट, फ्यूज", "الأسلاك والمصهرات"),
                    icon = Icons.Default.Bolt,
                    accentColor = Color(0xFFFFD600),
                    onClick = onNavigateToElectrical,
                    modifier = Modifier.weight(1f),
                    testTag = "home_quick_electrical"
                )
                QuickNavCard(
                    title = tr(language, "Training", "मैकेनिक ट्रेनिंग", "التدريب العملي"),
                    subtitle = tr(language, "Audio & Steps", "दैनिक सर्विस", "شروحات صوتية وخطوات"),
                    icon = Icons.Default.School,
                    accentColor = Color(0xFF4CAF50),
                    onClick = onNavigateToTraining,
                    modifier = Modifier.weight(1f),
                    testTag = "home_quick_training"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                QuickNavCard(
                    title = tr(language, "Heavy Modules", "हैवी मशीनरी मॉड्यूल्स", "وحدات الصيانة المتقدمة"),
                    subtitle = tr(language, "Overhaul, Pressures, Oil", "ओवरहाल, प्रेशर, ऑयल", "التوضيب، الضغط، الزيوت"),
                    icon = Icons.Default.Engineering,
                    accentColor = Color(0xFF00E676),
                    onClick = onNavigateToAdvancedModules,
                    modifier = Modifier.weight(1f),
                    testTag = "home_quick_advanced"
                )
                QuickNavCard(
                    title = tr(language, "JCB & CAT Models", "जेसीबी मॉडल सूची", "موديلات JCB و CAT"),
                    subtitle = tr(language, "3CX, 4CX, 3DX, 5CX, CAT", "3CX, 3DX, NXT, CAT", "المواصفات والقدرات"),
                    icon = Icons.Default.PrecisionManufacturing,
                    accentColor = Color(0xFF00B0FF),
                    onClick = onNavigateToModels,
                    modifier = Modifier.weight(1f),
                    testTag = "home_quick_models"
                )
            }
        }

        // Section: Complete 15 Machine Systems
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = tr(
                        language,
                        "15 Complete Machine Systems",
                        "मशीन के 15 मुख्य सिस्टम",
                        "أنظمة الآلة الـ 15 الكاملة"
                    ),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                TextButton(onClick = onNavigateToParts) {
                    Text(
                        text = tr(language, "View All", "सभी देखें", "عرض الكل"),
                        color = JcbYellow,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(SystemCategory.values()) { system ->
                    SystemCategoryChip(
                        system = system,
                        language = language,
                        onClick = { onSelectSystem(system) }
                    )
                }
            }
        }

        // Section: Popular JCB Machinery Showcase
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = tr(
                        language,
                        "JCB Machinery Lineup",
                        "लोकप्रिय जेसीबी मॉडल",
                        "تشكيلة معدات JCB"
                    ),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                TextButton(onClick = onNavigateToModels) {
                    Text(
                        text = tr(
                            language,
                            "All ${JcbMachineDatabase.machines.size} Models",
                            "सभी ${JcbMachineDatabase.machines.size} मॉडल",
                            "كل الموديلات (${JcbMachineDatabase.machines.size})"
                        ),
                        color = JcbYellow,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                JcbMachineDatabase.machines.take(3).forEach { machine ->
                    JcbMachineCard(
                        machine = machine,
                        language = language,
                        onClick = { onSelectMachine(machine) }
                    )
                }
            }
        }
    }
}

@Composable
fun QuickNavCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    accentColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    testTag: String
) {
    Card(
        modifier = modifier
            .clickable(onClick = onClick)
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
            .testTag(testTag),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(accentColor.copy(alpha = 0.18f), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun SystemCategoryChip(
    system: SystemCategory,
    language: AppLanguage,
    onClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f)),
        modifier = Modifier
            .clickable(onClick = onClick)
            .testTag("system_chip_${system.id}")
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(JcbYellow, RoundedCornerShape(2.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = system.title(language),
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun JcbMachineCard(
    machine: JcbMachineModel,
    language: AppLanguage,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
            .testTag("machine_card_${machine.id}"),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = machine.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Surface(
                    color = JcbYellow.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = machine.powerHp,
                        color = JcbYellow,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Text(
                text = machine.tag(language),
                style = MaterialTheme.typography.labelMedium,
                color = JcbYellow
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = machine.engineSpec.get(language),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${tr(language, "Weight:", "वजन:", "الوزن:")} ${machine.operatingWeight}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = tr(language, "View Specs", "पूर्ण स्पेक्स देखें", "عرض المواصفات"),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = JcbYellow,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}
