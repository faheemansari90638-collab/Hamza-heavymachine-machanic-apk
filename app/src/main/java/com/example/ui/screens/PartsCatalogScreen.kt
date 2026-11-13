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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.JcbPartsDatabase
import com.example.model.AppLanguage
import com.example.model.JcbPart
import com.example.model.SystemCategory
import com.example.model.tr
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

private val ModelFilters = listOf("3CX", "4CX", "3DX", "5CX", "CAT")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartsCatalogScreen(
    language: AppLanguage,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    bookmarkedPartIds: Set<String>,
    onToggleBookmark: (String) -> Unit,
    onSelectPart: (JcbPart) -> Unit,
    initialSystemFilter: SystemCategory? = null,
    selectedModelFilter: String? = null,
    onModelFilterChange: (String?) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedSystemFilter by remember(initialSystemFilter) {
        mutableStateOf<SystemCategory?>(initialSystemFilter)
    }

    val filteredParts = remember(searchQuery, selectedSystemFilter, selectedModelFilter) {
        JcbPartsDatabase.searchParts(
            query = searchQuery,
            categoryFilter = selectedSystemFilter,
            modelFilter = selectedModelFilter
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("parts_catalog_screen")
    ) {
        // Search Input Field (supports EN / Hindi / Arabic)
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .testTag("parts_search_input"),
            placeholder = {
                Text(
                    text = tr(
                        language,
                        "Search part name (EN/HI/AR), part # or system...",
                        "पार्ट्स का नाम, पार्ट नंबर या सिस्टम खोजें...",
                        "ابحث باسم القطعة أو الرقم التسلسلي أو النظام..."
                    ),
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
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

        // Row 1: 15 System Category Filter Pills
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                FilterChip(
                    selected = selectedSystemFilter == null,
                    onClick = { selectedSystemFilter = null },
                    label = {
                        Text(
                            text = tr(language, "All 15 Systems", "सभी 15 सिस्टम", "كل الأنظمة (15)"),
                            fontWeight = if (selectedSystemFilter == null) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = JcbYellow,
                        selectedLabelColor = JcbBlack
                    ),
                    modifier = Modifier.testTag("filter_all_systems")
                )
            }
            items(SystemCategory.values()) { category ->
                FilterChip(
                    selected = selectedSystemFilter == category,
                    onClick = {
                        selectedSystemFilter = if (selectedSystemFilter == category) null else category
                    },
                    label = {
                        Text(
                            text = category.title(language),
                            fontWeight = if (selectedSystemFilter == category) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = JcbYellow,
                        selectedLabelColor = JcbBlack
                    ),
                    modifier = Modifier.testTag("filter_${category.id}")
                )
            }
        }

        // Row 2: Machine Model Compatibility Filter Chips
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            item {
                AssistChip(
                    onClick = { onModelFilterChange(null) },
                    label = {
                        Text(
                            text = tr(language, "All Models", "सभी मॉडल", "كل الموديلات"),
                            fontSize = 11.sp,
                            fontWeight = if (selectedModelFilter == null) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (selectedModelFilter == null) JcbYellow.copy(alpha = 0.22f) else MaterialTheme.colorScheme.surfaceVariant,
                        labelColor = if (selectedModelFilter == null) JcbYellow else MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    modifier = Modifier.testTag("model_filter_all")
                )
            }
            items(ModelFilters) { modelKey ->
                val isSelected = selectedModelFilter == modelKey
                AssistChip(
                    onClick = {
                        onModelFilterChange(if (isSelected) null else modelKey)
                    },
                    label = {
                        Text(
                            text = if (modelKey == "CAT") "CAT Backhoe" else "JCB $modelKey",
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (isSelected) JcbYellow else MaterialTheme.colorScheme.surfaceVariant,
                        labelColor = if (isSelected) JcbBlack else MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    modifier = Modifier.testTag("model_filter_$modelKey")
                )
            }
        }

        // Result Count Banner
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = tr(
                    language,
                    "HD Parts Library: ${filteredParts.size}",
                    "कुल पार्ट्स फोटो लाइब्रेरी: ${filteredParts.size}",
                    "مكتبة صور القطع: ${filteredParts.size}"
                ),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = tr(
                    language,
                    "100% Offline • Trilingual",
                    "100% ऑफ़लाइन • 3 भाषाएँ",
                    "100% بدون إنترنت • 3 لغات"
                ),
                style = MaterialTheme.typography.labelSmall,
                color = JcbYellow,
                fontWeight = FontWeight.SemiBold
            )
        }

        // Parts List
        if (filteredParts.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.SearchOff,
                        contentDescription = null,
                        modifier = Modifier.size(56.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = tr(
                            language,
                            "No matching parts found. Try another English, Hindi, or Arabic term.",
                            "कोई पुर्जा नहीं मिला। कृपया दूसरा नाम या पार्ट नंबर खोजें।",
                            "لم يتم العثور على قطع مطابقة. جرّب كلمة بحث أخرى."
                        ),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredParts, key = { it.id }) { part ->
                    val isBookmarked = bookmarkedPartIds.contains(part.id)
                    PartItemCard(
                        part = part,
                        language = language,
                        isBookmarked = isBookmarked,
                        onToggleBookmark = { onToggleBookmark(part.id) },
                        onClick = { onSelectPart(part) }
                    )
                }
            }
        }
    }
}

@Composable
fun PartItemCard(
    part: JcbPart,
    language: AppLanguage,
    isBookmarked: Boolean,
    onToggleBookmark: () -> Unit,
    onClick: () -> Unit
) {
    val secondaryNames = when (language) {
        AppLanguage.ENGLISH -> "${part.nameHi}  •  ${part.nameAr}"
        AppLanguage.HINDI -> "${part.nameEn}  •  ${part.nameAr}"
        AppLanguage.ARABIC -> "${part.nameEn}  •  ${part.nameHi}"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
            .testTag("part_card_${part.id}"),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.Top
            ) {
                // Dedicated single-part white-background studio thumbnail
                Box(
                    modifier = Modifier
                        .size(88.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .border(1.dp, JcbYellow.copy(alpha = 0.45f), RoundedCornerShape(10.dp))
                        .padding(6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = part.imageResId),
                        contentDescription = "${part.nameEn} (${part.nameHi} / ${part.nameAr})",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = JcbYellow.copy(alpha = 0.16f),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = part.system.title(language),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = JcbYellow,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }

                        IconButton(
                            onClick = onToggleBookmark,
                            modifier = Modifier.size(34.dp)
                        ) {
                            Icon(
                                imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                                contentDescription = tr(language, "Bookmark", "बुकमार्क", "حفظ القطعة"),
                                tint = if (isBookmarked) JcbYellow else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = part.name(language),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = secondaryNames,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = part.workingPrinciple.get(language),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    Text(
                        text = "P/N: ${part.partNumber}",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = tr(language, "Photo & Repair", "फोटो और रिपेयर", "الصورة والإصلاح"),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = JcbYellow,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}
