package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import com.example.data.JcbElectricalDatabase
import com.example.model.*
import com.example.ui.components.InteractiveCircuitSchematicView
import com.example.ui.components.OfficialManualCallout
import com.example.ui.components.VoiceExplanationButton
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElectricalMasterScreen(
    language: AppLanguage,
    selectedCategory: ElectricalCategory,
    onCategorySelected: (ElectricalCategory) -> Unit,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("electrical_master_screen")
    ) {
        // Search bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .testTag("electrical_search_input"),
            placeholder = {
                Text(
                    text = tr(
                        language,
                        "Search wire color, relay (R1), fuse (F1), sensor...",
                        "तार का रंग, रिले (R1), फ्यूज (F1), सेंसर या लाइट खोजें...",
                        "ابحث بلون السلك، المرحل (R1)، المصهر (F1)، أو الحساس..."
                    ),
                    fontSize = 12.sp
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

        // Horizontal Category Tab Pills
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(ElectricalCategory.values()) { category ->
                val isSelected = selectedCategory == category
                FilterChip(
                    selected = isSelected,
                    onClick = { onCategorySelected(category) },
                    label = {
                        Text(
                            text = category.title(language),
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = JcbYellow,
                        selectedLabelColor = JcbBlack
                    ),
                    modifier = Modifier.testTag("elec_tab_${category.id}")
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Content Display based on selected category
        when (selectedCategory) {
            ElectricalCategory.HARNESSES -> {
                HarnessesSection(language = language, searchQuery = searchQuery, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            ElectricalCategory.LIGHTING -> {
                LightingSection(language = language, searchQuery = searchQuery, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            ElectricalCategory.FUSE_BOX -> {
                FuseBoxSection(language = language, searchQuery = searchQuery, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            ElectricalCategory.RELAYS -> {
                RelaysSection(language = language, searchQuery = searchQuery, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            ElectricalCategory.SENSORS -> {
                SensorsSection(language = language, searchQuery = searchQuery, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            ElectricalCategory.SWITCHES -> {
                SwitchesSection(language = language, searchQuery = searchQuery, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            ElectricalCategory.STARTING_CHARGING -> {
                StartingChargingSection(language = language, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            ElectricalCategory.MULTIMETER_TRAINING -> {
                MultimeterSection(language = language, searchQuery = searchQuery, isSpeaking = isSpeaking, onSpeakVoice = onSpeakVoice)
            }
            ElectricalCategory.WIRE_COLOUR_CODES -> {
                ColourCodesSection(language = language, searchQuery = searchQuery)
            }
            ElectricalCategory.CONNECTORS_PINOUTS -> {
                ConnectorsSection(language = language, searchQuery = searchQuery)
            }
            ElectricalCategory.SCHEMATIC_DIAGRAMS -> {
                SchematicsSection(language = language)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 1. WIRING HARNESSES SECTION
// -------------------------------------------------------------------------------------------------
@Composable
fun HarnessesSection(
    language: AppLanguage,
    searchQuery: String,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbElectricalDatabase.searchHarnesses(searchQuery)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, JcbYellow.copy(alpha = 0.5f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = tr(
                            language,
                            "Backhoe Loader Complete Wiring Looms",
                            "बैकहो लोडर संपूर्ण वायरिंग लूम गाइड",
                            "الدليل الشامل لضفائر الأسلاك (الحفار اللودر)"
                        ),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Text(
                        text = tr(
                            language,
                            "Wire colors, ID codes, gauge sizes, voltage ratings, start/end nodes, and terminal pinouts.",
                            "तार का रंग, तार संख्या, गेज (मोटाई), वोल्टेज, स्टार्टिंग/एंडिंग पॉइंट और पिनआउट विवरण।",
                            "ألوان الأسلاك، أرقام التمييز، المقاس، الجهد الكهربائي، ونقاط البداية والنهاية وتوزيع الأطراف."
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        items(items) { harness ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = harness.name(language),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )
                        Surface(
                            color = JcbYellow,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = "${harness.wires.size} ${tr(language, "Wires", "मुख्य तार", "أسلاك")}",
                                fontWeight = FontWeight.Bold,
                                color = JcbBlack,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${tr(language, "Models:", "मॉडल:", "الموديلات:")} ${harness.machineModels.joinToString(", ")}",
                        style = MaterialTheme.typography.labelSmall,
                        color = JcbYellow
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = harness.locationDescription.get(language),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = tr(
                            language,
                            "Detailed Wire Circuits:",
                            "वायरिंग विवरण एवं सर्किट पाथ:",
                            "تفاصيل الدوائر ومسارات الأسلاك:"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    harness.wires.forEach { wire ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Box(
                                            modifier = Modifier
                                                .size(12.dp)
                                                .background(Color(wire.hexPrimary), RoundedCornerShape(2.dp))
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = "${wire.wireId} • ${wire.colourCode}",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp
                                        )
                                    }
                                    Text(
                                        text = wire.circuitVoltage,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (wire.circuitVoltage.contains("0V")) Color(0xFF4CAF50) else Color(0xFFFF5252)
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "${wire.gaugeMm2} | ${wire.startLocation.get(language)} (${wire.connectorPinStart}) ➜ ${wire.endLocation.get(language)} (${wire.connectorPinEnd})",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = wire.purpose.get(language),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    OfficialManualCallout(manualText = harness.manualReference, language = language)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 2. LIGHTS AND LIGHT CABLES SECTION
// -------------------------------------------------------------------------------------------------
@Composable
fun LightingSection(
    language: AppLanguage,
    searchQuery: String,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbElectricalDatabase.searchLights(searchQuery)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { light ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = light.name(language),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )
                        Surface(
                            color = JcbYellow,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = light.bulbTypeAndWattage.substringBefore('('),
                                fontWeight = FontWeight.Bold,
                                color = JcbBlack,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "${tr(language, "Location:", "स्थान:", "الموقع:")} ${light.positionOnMachine.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = tr(language, "Positive (+) Wire:", "पॉजिटिव (+) तार:", "السلك الموجب (+):"),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = light.positiveWireColour,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF00B0FF)
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = tr(language, "Negative (-) Ground:", "अर्थिंग (-) तार:", "السلك السالب (- التأريض):"),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = light.negativeWireColour,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = tr(language, "Fuse Protection:", "फ्यूज संख्या:", "حماية المصهر:"),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = light.fuseNumberAndRating,
                                style = MaterialTheme.typography.bodySmall,
                                color = JcbYellow
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = tr(language, "Relay Unit:", "रिले नियंत्रण:", "وحدة المرحل (الكتاوت):"),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = light.relayNumber,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${tr(language, "Connector & Pins:", "कनेक्टर और पिंस:", "الموصل والأطراف:")} ${light.connectorAndPins}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = tr(
                            language,
                            "Testing & Troubleshooting Steps:",
                            "टेस्टिंग एवं फॉल्ट निवारण प्रक्रिया:",
                            "خطوات الفحص وإصلاح الأعطال:"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4CAF50)
                    )
                    light.testingProcedure.forEach { step ->
                        Text(
                            text = "• ${step.get(language)}",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(vertical = 2.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    OfficialManualCallout(manualText = light.manualReference, language = language)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 3. FUSE BOX SYSTEM
// -------------------------------------------------------------------------------------------------
@Composable
fun FuseBoxSection(
    language: AppLanguage,
    searchQuery: String,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbElectricalDatabase.fuses.filter {
        val q = searchQuery.trim().lowercase()
        q.isEmpty() ||
                it.fuseId.lowercase().contains(q) ||
                it.protectedCircuitsEn.lowercase().contains(q) ||
                it.protectedCircuitsHi.lowercase().contains(q) ||
                it.protectedCircuitsAr.lowercase().contains(q) ||
                "${it.ratingAmps}".contains(q)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFFFF5252).copy(alpha = 0.5f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFF5252).copy(alpha = 0.1f))
            ) {
                Row(modifier = Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Shield, contentDescription = null, tint = Color(0xFFFF5252))
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = tr(
                            language,
                            "SAFETY MANDATE: Never exceed factory fuse ratings or bridge blown fuses with copper wire strands!",
                            "चेतावनी: कभी भी निर्माता विनिर्देश से अधिक एम्पीयर का फ्यूज न लगाएं और न ही तांबे का तार बांधें!",
                            "تحذير سلامة: لا تضع مصهراً بأمبير أعلى من الموصى به ولا تستخدم سلكاً نحاسياً لتوصيل مصهر محترق!"
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF5252)
                    )
                }
            }
        }

        items(items) { fuse ->
            val fuseColor = when (fuse.ratingAmps) {
                10 -> Color(0xFFD32F2F) // Red
                15 -> Color(0xFF1976D2) // Blue
                20 -> Color(0xFFFBC02D) // Yellow
                25 -> Color(0xFFEEEEEE) // White
                30 -> Color(0xFF388E3C) // Green
                else -> Color(0xFFFF9800)
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .background(fuseColor, RoundedCornerShape(6.dp))
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "${fuse.fuseId} • ${fuse.ratingAmps}A",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 12.sp,
                                    color = if (fuse.ratingAmps == 20 || fuse.ratingAmps == 25) Color.Black else Color.White
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = fuse.boxLocation.title(language),
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = fuse.protectedCircuits(language),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "${tr(language, "Blown Fuse Symptoms:", "फ्यूज उड़ने के लक्षण:", "أعراض احتراق المصهر:")} ${fuse.blownSymptoms.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFFFF9800)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(language, "Troubleshooting Steps:", "शॉर्ट सर्किट जांचने के कदम:", "خطوات فحص الدائرة:"),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    fuse.troubleshootingSteps.forEach { step ->
                        Text(
                            text = "• ${step.get(language)}",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(vertical = 2.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = fuse.warningNote.get(language),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.error,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 4. RELAYS SECTION
// -------------------------------------------------------------------------------------------------
@Composable
fun RelaysSection(
    language: AppLanguage,
    searchQuery: String,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbElectricalDatabase.relays.filter {
        val q = searchQuery.trim().lowercase()
        q.isEmpty() ||
                it.relayId.lowercase().contains(q) ||
                it.functionEn.lowercase().contains(q) ||
                it.functionHi.lowercase().contains(q) ||
                it.functionAr.lowercase().contains(q)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { relay ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${relay.relayId} (${relay.function(language)})",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )
                        Surface(
                            color = JcbYellow,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = "ISO Relay",
                                fontWeight = FontWeight.Bold,
                                color = JcbBlack,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = tr(
                            language,
                            "Standard Relay Terminal Identification:",
                            "मानक रिले पिनआउट पहचान (Terminal Pinout):",
                            "تحديد أطراف المرحل القياسي (ISO Relay Pinout):"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("• Pin 85 (Coil Ground): ${relay.pin85.get(language)}", style = MaterialTheme.typography.bodySmall)
                        Text("• Pin 86 (Coil Control 12V): ${relay.pin86.get(language)}", style = MaterialTheme.typography.bodySmall)
                        Text("• Pin 30 (High Current Feed): ${relay.pin30.get(language)}", style = MaterialTheme.typography.bodySmall)
                        Text("• Pin 87 (Normally Open Output): ${relay.pin87.get(language)}", style = MaterialTheme.typography.bodySmall)
                        relay.pin87a?.let {
                            Text("• Pin 87a (Normally Closed Output): ${it.get(language)}", style = MaterialTheme.typography.bodySmall)
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "${tr(language, "Coil Resistance:", "कॉइल प्रतिरोध (Coil Resistance):", "مقاومة الملف:")} ${relay.resistanceOhmsCoil}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00B0FF)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(language, "Relay Bench Testing Procedure:", "बेंच पर रिले टेस्टिंग विधि:", "طريقة فحص المرحل:"),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    relay.testingProcedure.forEach { step ->
                        Text("• ${step.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                        color = Color(0xFFFF9800).copy(alpha = 0.12f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = relay.jumperBypassWarning.get(language),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFFFF9800),
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Part No: ${relay.replacementPartNo}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 5. ELECTRICAL SENSORS SECTION
// -------------------------------------------------------------------------------------------------
@Composable
fun SensorsSection(
    language: AppLanguage,
    searchQuery: String,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbElectricalDatabase.searchSensors(searchQuery)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { sensor ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = sensor.name(language),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${tr(language, "Models:", "मशीन मॉडल:", "الموديلات:")} ${sensor.applicableMachines.joinToString(", ")}",
                        style = MaterialTheme.typography.labelSmall,
                        color = JcbYellow
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${tr(language, "Location:", "स्थान:", "الموقع:")} ${sensor.physicalLocation.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = tr(language, "Operating Voltage:", "ऑपरेटिंग वोल्टेज:", "جهد التشغيل:"),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = sensor.operatingVoltage, style = MaterialTheme.typography.bodySmall, color = Color(0xFF00B0FF))
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = tr(language, "Signal Type:", "सिग्नल प्रकार:", "نوع الإشارة:"),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = sensor.outputSignalType.get(language), style = MaterialTheme.typography.bodySmall)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${tr(language, "Standard Spec:", "सामान्य मान:", "القيمة القياسية:")} ${sensor.normalResistanceOrSpecs}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4CAF50)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(
                            language,
                            "Multimeter Bench Testing Method:",
                            "मल्टीमीटर बेंच टेस्टिंग विधि:",
                            "طريقة الفحص بالملتيميتر:"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    sensor.multimeterBenchTesting.forEach { step ->
                        Text("• ${step.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    OfficialManualCallout(manualText = sensor.manualReference, language = language)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 6. SWITCHES SECTION
// -------------------------------------------------------------------------------------------------
@Composable
fun SwitchesSection(
    language: AppLanguage,
    searchQuery: String,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbElectricalDatabase.switches

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { sw ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = sw.name(language),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = sw.switchType,
                        style = MaterialTheme.typography.labelSmall,
                        color = JcbYellow
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${tr(language, "Location:", "स्थान:", "الموقع:")} ${sw.location.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = tr(language, "Terminal Pinouts:", "पिनआउट पहचान:", "ترتيب الأطراف:"),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    sw.terminalPinout.forEach { pin ->
                        Text("• ${pin.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(
                            language,
                            "Continuity Truth Table:",
                            "कंटिन्यूटी ट्रुथ टेबल (स्विच स्थिति अनुसार जुड़ाव):",
                            "جدول فحص التوصيل (الاستمرارية):"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4CAF50)
                    )
                    sw.normalContinuityTruthTable.forEach { row ->
                        Text("• ${row.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tr(language, "Multimeter Testing Method:", "मल्टीमीटर टेस्टिंग विधि:", "طريقة الفحص بالملتيميتر:"),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    sw.testingWithMultimeter.forEach { step ->
                        Text("• ${step.get(language)}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 7. BATTERY, STARTER & ALTERNATOR SECTION
// -------------------------------------------------------------------------------------------------
@Composable
fun StartingChargingSection(
    language: AppLanguage,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val data = JcbElectricalDatabase.startingChargingData

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, JcbYellow.copy(alpha = 0.5f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = tr(
                            language,
                            "Battery, Starter Motor & Alternator System",
                            "बैटरी, स्टार्टर मोटर एवं अल्टरनेटर गाइड",
                            "نظام البطارية والسلف (بادئ التشغيل) والدينامو"
                        ),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "${tr(language, "Battery:", "बैटरी:", "البطارية:")} ${data.batterySpecs.get(language)}", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "${tr(language, "Starter:", "स्टार्टर:", "السلف:")} ${data.starterMotorSpecs.get(language)}", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "${tr(language, "Alternator:", "अल्टरनेटर:", "الدينامو:")} ${data.alternatorSpecs.get(language)}", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFF00B0FF).copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = tr(
                            language,
                            "Charging System Target Test Voltages",
                            "चार्जिंग वोल्टेज एवं बैटरी हेल्थ टेस्ट (मानक मान)",
                            "قيم الجهد القياسية لفحص الشحن والبطارية"
                        ),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00B0FF)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    data.chargingVoltages.forEach { v ->
                        Text("• ${v.get(language)}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 2.dp))
                    }
                }
            }
        }

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFFFF9800).copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = tr(
                            language,
                            "Battery Isolator Switch Mandatory Safety",
                            "बैटरी कट-ऑफ (आइसोलेटर) स्विच सुरक्षा नियम",
                            "قواعد السلامة لمفتاح فصل البطارية الرئيسي"
                        ),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF9800)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    data.isolatorSwitchProcedure.forEach { p ->
                        Text("• ${p.get(language)}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 2.dp))
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 8. MULTIMETER TRAINING MASTERCLASS SECTION
// -------------------------------------------------------------------------------------------------
@Composable
fun MultimeterSection(
    language: AppLanguage,
    searchQuery: String,
    isSpeaking: Boolean,
    onSpeakVoice: (String) -> Unit
) {
    val items = JcbElectricalDatabase.multimeterTutorials

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { t ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, JcbYellow.copy(alpha = 0.5f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = t.title(language),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )
                        Surface(
                            color = JcbYellow,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = t.meterSetting,
                                fontWeight = FontWeight.Bold,
                                color = JcbBlack,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Ports: Red Lead ➜ ${t.redLeadPort} | Black Lead ➜ ${t.blackLeadPort}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00B0FF)
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Surface(
                        color = Color(0xFFFF5252).copy(alpha = 0.12f),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = "${tr(language, "SAFETY:", "सुरक्षा:", "السلامة:")} ${t.safetyFirstRule.get(language)}",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFFFF5252),
                            modifier = Modifier.padding(6.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = tr(language, "Step-by-Step Testing Procedure:", "कदम-दर-कदम टेस्टिंग प्रक्रिया:", "خطوات الفحص التدريجية:"),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    t.stepByStepTesting.forEach { step ->
                        Text("• ${step.get(language)}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 1.dp))
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${tr(language, "Normal Reading:", "सही रीडिंग:", "القراءة السليمة:")} ${t.goodReadingInterpretation.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF4CAF50),
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${tr(language, "Fault Reading:", "खराब रीडिंग:", "قراءة العطل:")} ${t.badReadingInterpretation.get(language)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFFFF5252),
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "${tr(language, "JCB Example:", "जेसीबी उदाहरण:", "مثال JCB:")} ${t.realJcbExample.get(language)}",
                        style = MaterialTheme.typography.labelSmall,
                        color = JcbYellow
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 9. WIRE COLOUR CODE LIBRARY
// -------------------------------------------------------------------------------------------------
@Composable
fun ColourCodesSection(
    language: AppLanguage,
    searchQuery: String
) {
    val items = JcbElectricalDatabase.wireColourCodes.filter {
        val q = searchQuery.trim().lowercase()
        q.isEmpty() ||
                it.code.lowercase().contains(q) ||
                it.baseColourEn.lowercase().contains(q) ||
                it.baseColourHi.lowercase().contains(q) ||
                it.baseColourAr.lowercase().contains(q) ||
                it.typicalCircuitEn.lowercase().contains(q) ||
                it.typicalCircuitHi.lowercase().contains(q) ||
                it.typicalCircuitAr.lowercase().contains(q)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items) { c ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(Color(c.hexColor), RoundedCornerShape(8.dp))
                            .border(1.dp, Color.White.copy(alpha = 0.3f), RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = c.code,
                            fontWeight = FontWeight.Black,
                            fontSize = 12.sp,
                            color = if (c.hexColor == 0xFFEEEEEE || c.hexColor == 0xFFFBC02D) Color.Black else Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = c.baseColour(language),
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = c.typicalCircuit(language),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = c.rule(language),
                            style = MaterialTheme.typography.labelSmall,
                            color = JcbYellow
                        )
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 10. CONNECTORS & PINOUT DATABASE
// -------------------------------------------------------------------------------------------------
@Composable
fun ConnectorsSection(
    language: AppLanguage,
    searchQuery: String
) {
    val items = JcbElectricalDatabase.connectors

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(items) { conn ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "${conn.connectorId} • ${conn.typeAndHousing}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Text(
                        text = conn.systemAndLoom.get(language),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = tr(
                            language,
                            "Pinout Details & Voltage Levels:",
                            "पिन विवरण एवं वोल्टेज (Pinout Table):",
                            "تفاصيل الأطراف ومستويات الجهد:"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    conn.pins.forEach { pin ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 3.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Surface(
                                        color = JcbYellow,
                                        shape = RoundedCornerShape(4.dp)
                                    ) {
                                        Text(
                                            text = "Pin ${pin.pinNumber}",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 11.sp,
                                            color = JcbBlack,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = pin.signalFunction(language),
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 12.sp
                                        )
                                        Text(
                                            text = "${pin.wireColour} | ${pin.nominalVoltage}",
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }

                                Text(
                                    text = pin.testExpectedValue,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF4CAF50)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${tr(language, "Caution:", "सावधानी:", "تنبيه:")} ${conn.probePrecaution.get(language)}",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFFFF9800)
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// 11. SCHEMATIC DIAGRAMS SECTION (WITH INTERACTIVE ZOOM & ROTATE)
// -------------------------------------------------------------------------------------------------
@Composable
fun SchematicsSection(language: AppLanguage) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            InteractiveCircuitSchematicView(
                circuitTitle = tr(
                    language,
                    "Engine Starter & Alternator Charging Circuit",
                    "इंजन स्टार्टर एवं चार्जिंग सर्किट",
                    "دائرة بادئ تشغيل المحرك وشحن الدينامو"
                ),
                machineModel = "JCB 3DX / 3CX Eco Series",
                language = language
            )
        }

        item {
            InteractiveCircuitSchematicView(
                circuitTitle = tr(
                    language,
                    "Headlamp & Roof Work Light Relay Circuit",
                    "हेडलाइट व फ्रंट/रियर वर्क लाइट रिले सर्किट",
                    "دائرة مرحل المصابيح الأمامية وكشافات العمل"
                ),
                machineModel = "JCB 4CX / 5CX Heavy Series",
                language = language
            )
        }

        item {
            InteractiveCircuitSchematicView(
                circuitTitle = tr(
                    language,
                    "Synchroshuttle Directional Solenoid Circuit",
                    "ट्रांसमिशन फॉरवर्ड/रिवर्स शटल सोलेनोइड सर्किट",
                    "دائرة صمام اتجاه ناقل الحركة (أمام/خلف)"
                ),
                machineModel = "JCB 3DX Super / CAT 424B",
                language = language
            )
        }
    }
}
