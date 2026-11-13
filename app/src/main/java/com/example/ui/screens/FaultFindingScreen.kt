package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
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
import com.example.data.JcbFaultDatabase
import com.example.model.*
import com.example.ui.theme.JcbYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FaultFindingScreen(
    language: AppLanguage,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    activeTab: Int,
    onTabSelected: (Int) -> Unit,
    onSelectErrorCode: (JcbErrorCode) -> Unit,
    onSelectDiagnosticGuide: (DiagnosticGuide) -> Unit,
    modifier: Modifier = Modifier
) {
    val q = searchQuery.trim().lowercase()
    val filteredCodes = JcbFaultDatabase.errorCodes.filter {
        q.isEmpty() ||
                it.code.lowercase().contains(q) ||
                it.title.en.lowercase().contains(q) ||
                it.title.hi.lowercase().contains(q) ||
                it.title.ar.lowercase().contains(q) ||
                it.system.titleEn.lowercase().contains(q) ||
                it.system.titleHi.lowercase().contains(q) ||
                it.system.titleAr.lowercase().contains(q)
    }

    val filteredGuides = JcbFaultDatabase.diagnosticGuides.filter {
        q.isEmpty() ||
                it.title.en.lowercase().contains(q) ||
                it.title.hi.lowercase().contains(q) ||
                it.title.ar.lowercase().contains(q) ||
                it.category.lowercase().contains(q)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("fault_finding_screen")
    ) {
        // Search Input Field
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .testTag("faults_search_input"),
            placeholder = {
                Text(
                    text = tr(
                        language,
                        "Search Error Code (e.g. P0087) or symptoms...",
                        "त्रुटि कोड (P0087, H0042) या समस्या खोजें...",
                        "ابحث برمز العطل (P0087) أو الأعراض..."
                    ),
                    fontSize = 13.sp
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

        // Tab Row: Error Codes vs Diagnostic Trees
        TabRow(
            selectedTabIndex = activeTab,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = JcbYellow,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Tab(
                selected = activeTab == 0,
                onClick = { onTabSelected(0) },
                text = {
                    Text(
                        text = tr(
                            language,
                            "Error Codes (${filteredCodes.size})",
                            "फॉल्ट कोड्स (${filteredCodes.size})",
                            "أكواد الأعطال (${filteredCodes.size})"
                        ),
                        fontWeight = if (activeTab == 0) FontWeight.Bold else FontWeight.Normal
                    )
                },
                modifier = Modifier.testTag("tab_error_codes")
            )
            Tab(
                selected = activeTab == 1,
                onClick = { onTabSelected(1) },
                text = {
                    Text(
                        text = tr(
                            language,
                            "Troubleshooting (${filteredGuides.size})",
                            "समस्या निदान (${filteredGuides.size})",
                            "تتبع الأعطال (${filteredGuides.size})"
                        ),
                        fontWeight = if (activeTab == 1) FontWeight.Bold else FontWeight.Normal
                    )
                },
                modifier = Modifier.testTag("tab_diagnostic_trees")
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        if (activeTab == 0) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredCodes, key = { it.code }) { code ->
                    ErrorCodeCard(
                        code = code,
                        language = language,
                        onClick = { onSelectErrorCode(code) }
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredGuides, key = { it.id }) { guide ->
                    DiagnosticGuideCard(
                        guide = guide,
                        language = language,
                        onClick = { onSelectDiagnosticGuide(guide) }
                    )
                }
            }
        }
    }
}

@Composable
fun ErrorCodeCard(
    code: JcbErrorCode,
    language: AppLanguage,
    onClick: () -> Unit
) {
    val severityColor = when (code.severity) {
        ErrorSeverity.CRITICAL_STOP -> Color(0xFFFF5252)
        ErrorSeverity.WARNING_CAUTION -> Color(0xFFFF9800)
        ErrorSeverity.MAINTENANCE_ADVISORY -> Color(0xFF00B0FF)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .border(1.dp, severityColor.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
            .testTag("error_code_${code.code}"),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .background(severityColor, RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = code.code,
                            fontWeight = FontWeight.Black,
                            fontSize = 13.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = code.system.title(language),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Surface(
                    color = severityColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = if (code.canOperate)
                            tr(language, "Caution", "सतर्कता से चलाएं", "تشغيل بحذر")
                        else
                            tr(language, "STOP WORK", "मशीन रोकें", "أوقف العمل فوراً"),
                        color = severityColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = code.title.get(language),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = code.symptoms.get(language),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = code.warningLampType,
                    style = MaterialTheme.typography.labelSmall,
                    color = severityColor
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = tr(language, "Fix Steps", "निवारण कदम", "خطوات الإصلاح"),
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

@Composable
fun DiagnosticGuideCard(
    guide: DiagnosticGuide,
    language: AppLanguage,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
            .testTag("diagnostic_guide_${guide.id}"),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Surface(
                color = JcbYellow.copy(alpha = 0.15f),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = guide.category,
                    color = JcbYellow,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = guide.title.get(language),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = guide.overview.get(language),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${guide.symptomChecks.size} ${tr(language, "Diagnostic Steps", "जांच कदम", "خطوة فحص")}",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(0xFF4CAF50),
                    fontWeight = FontWeight.Bold
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = tr(language, "Start Diagnosis", "जांच शुरू करें", "بدء الفحص"),
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
