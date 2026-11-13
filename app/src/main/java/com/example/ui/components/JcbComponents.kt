package com.example.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.tr
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

/**
 * Top App Bar with JCB branding, Trilingual Language Selector (EN / हिंदी / العربية),
 * Theme switch, Bookmarks shortcut, and RTL-aware Back navigation.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JcbTopBar(
    title: String,
    subtitle: String? = null,
    currentLanguage: AppLanguage,
    isDarkTheme: Boolean,
    showBackButton: Boolean = false,
    onBackClick: () -> Unit = {},
    onLanguageSelected: (AppLanguage) -> Unit = {},
    onThemeToggle: () -> Unit = {},
    onBookmarkListClick: () -> Unit = {}
) {
    var langMenuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(JcbYellow, RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "JCB",
                            fontWeight = FontWeight.Black,
                            fontSize = 11.sp,
                            color = JcbBlack
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (subtitle != null) {
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.testTag("nav_back_button")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = tr(currentLanguage, "Back", "वापस", "رجوع")
                    )
                }
            }
        },
        actions = {
            Box {
                FilledTonalButton(
                    onClick = { langMenuExpanded = true },
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                    modifier = Modifier
                        .height(36.dp)
                        .testTag("language_selector_button"),
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = JcbYellow,
                        contentColor = JcbBlack
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Translate,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = currentLanguage.label,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }

                DropdownMenu(
                    expanded = langMenuExpanded,
                    onDismissRequest = { langMenuExpanded = false },
                    modifier = Modifier.testTag("language_dropdown_menu")
                ) {
                    AppLanguage.values().forEach { langOption ->
                        DropdownMenuItem(
                            text = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "${langOption.label} (${langOption.shortCode})",
                                        fontWeight = if (langOption == currentLanguage) FontWeight.Bold else FontWeight.Normal
                                    )
                                    if (langOption == currentLanguage) {
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = null,
                                            tint = JcbYellow,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                }
                            },
                            onClick = {
                                onLanguageSelected(langOption)
                                langMenuExpanded = false
                            },
                            modifier = Modifier.testTag("language_option_${langOption.name.lowercase()}")
                        )
                    }
                }
            }

            IconButton(
                onClick = onBookmarkListClick,
                modifier = Modifier.testTag("top_bookmarks_button")
            ) {
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = tr(currentLanguage, "Saved Bookmarks", "सहेजे गए पुर्जे", "المحفوظات"),
                    tint = JcbYellow
                )
            }

            IconButton(
                onClick = onThemeToggle,
                modifier = Modifier.testTag("theme_toggle_button")
            ) {
                Icon(
                    imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = tr(currentLanguage, "Toggle Theme", "थीम बदलें", "تبديل المظهر")
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

/**
 * Bottom Navigation Bar with safe window insets and full trilingual labels
 */
@Composable
fun JcbBottomNavigation(
    selectedRouteIndex: Int,
    onTabSelected: (Int) -> Unit,
    language: AppLanguage
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .testTag("bottom_navigation_bar"),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp
    ) {
        val items = listOf(
            Triple(Icons.Default.Home, tr(language, "Home", "होम", "الرئيسية"), 0),
            Triple(Icons.Default.Build, tr(language, "Parts", "पार्ट्स", "القطع"), 1),
            Triple(Icons.Default.Bolt, tr(language, "Wiring", "वायरिंग", "الكهرباء"), 2),
            Triple(Icons.Default.Warning, tr(language, "Faults", "फॉल्ट", "الأعطال"), 3),
            Triple(Icons.Default.School, tr(language, "Training", "ट्रेनिंग", "التدريب"), 4)
        )

        items.forEach { (icon, label, index) ->
            val selected = selectedRouteIndex == index
            NavigationBarItem(
                selected = selected,
                onClick = { onTabSelected(index) },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = label,
                        modifier = Modifier.size(22.dp)
                    )
                },
                label = {
                    Text(
                        text = label,
                        fontSize = 11.sp,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = JcbBlack,
                    selectedTextColor = JcbYellow,
                    indicatorColor = JcbYellow,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                modifier = Modifier.testTag("nav_tab_$index")
            )
        }
    }
}

/**
 * Offline Mode Indicator Pill badge
 */
@Composable
fun OfflineStatusBadge(
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(Color(0xFF4CAF50), CircleShape)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = tr(
                    language,
                    "100% Offline Mode Active",
                    "100% ऑफलाइन मोड सक्रिय",
                    "الوضع بدون إنترنت نشط 100%"
                ),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

/**
 * Text-to-Speech Voice Button
 */
@Composable
fun VoiceExplanationButton(
    isSpeaking: Boolean,
    onSpeakClick: () -> Unit,
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    val bgColor by animateColorAsState(
        targetValue = if (isSpeaking) MaterialTheme.colorScheme.error else JcbYellow,
        label = "tts_color"
    )

    Button(
        onClick = onSpeakClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            contentColor = if (isSpeaking) Color.White else JcbBlack
        ),
        modifier = modifier.testTag("tts_voice_button")
    ) {
        Icon(
            imageVector = if (isSpeaking) Icons.AutoMirrored.Filled.VolumeOff else Icons.AutoMirrored.Filled.VolumeUp,
            contentDescription = tr(language, "Voice Reader", "आवाज गाइड", "القارئ الصوتي"),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = if (isSpeaking) {
                tr(language, "Stop Audio", "आवाज बंद करें", "إيقاف الصوت")
            } else {
                tr(language, "Listen Explanation", "हिंदी में सुनें", "استمع للشرح")
            },
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
        )
    }
}

/**
 * Official JCB Manual Reference Callout Card
 */
@Composable
fun OfficialManualCallout(
    manualText: String,
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f), RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(JcbYellow.copy(alpha = 0.2f), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = null,
                    tint = JcbYellow,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = tr(
                        language,
                        "Official Manufacturer Service Manual Ref:",
                        "आधिकारिक सर्विस मैन्युअल संदर्भ:",
                        "مرجع دليل الصيانة الرسمي:"
                    ),
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = JcbYellow
                )
                Text(
                    text = manualText,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
