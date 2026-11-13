package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.data.JcbMachineDatabase
import com.example.model.AppLanguage
import com.example.model.JcbMachineModel
import com.example.model.tr
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

@Composable
fun MachinesCatalogScreen(
    language: AppLanguage,
    onSelectMachine: (JcbMachineModel) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("machines_catalog_screen"),
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
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .background(JcbYellow, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.PrecisionManufacturing,
                                contentDescription = null,
                                tint = JcbBlack,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = tr(
                                    language,
                                    "JCB Heavy Machinery Models",
                                    "जेसीबी हेवी मशीनरी मॉडल्स",
                                    "موديلات معدات JCB الثقيلة"
                                ),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = tr(
                                    language,
                                    "3CX, 4CX, 5CX, 3DX, 2DX, NXT, Wheel Loaders",
                                    "3CX, 4CX, 5CX, 3DX, NXT, रोबोट, लोडर",
                                    "3CX, 4CX, 5CX, 3DX, 2DX, NXT واللوادر"
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
                            "Genuine technical specifications, hydraulic system pressures, engine models, and maintenance schedules for all major JCB machines.",
                            "सभी मुख्य मशीनों के वास्तविक तकनीकी विनिर्देश, हाइड्रोलिक दबाव, इंजन विनिर्देश और रखरखाव अंतराल की ऑफलाइन जानकारी।",
                            "المواصفات الفنية الدقيقة، ضغوط النظام الهيدروليكي، موديلات المحركات وجداول الصيانة الدورية لمعدات JCB."
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        items(JcbMachineDatabase.machines, key = { it.id }) { machine ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSelectMachine(machine) }
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
                    .testTag("machine_item_${machine.id}"),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(14.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = machine.name,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = machine.tag(language),
                                style = MaterialTheme.typography.labelSmall,
                                color = JcbYellow
                            )
                        }

                        Surface(
                            color = JcbYellow,
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = machine.powerHp,
                                fontWeight = FontWeight.Bold,
                                color = JcbBlack,
                                fontSize = 11.sp,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = machine.engineSpec.get(language),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            Column {
                                Text(
                                    text = tr(language, "Op. Weight", "ऑपरेटिंग वजन", "الوزن التشغيلي"),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = machine.operatingWeight,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Column {
                                Text(
                                    text = tr(language, "Hyd. Pressure", "हाइड्रोलिक प्रेशर", "الضغط الهيدروليكي"),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = machine.hydraulicPressureBar,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF00B0FF)
                                )
                            }
                        }

                        FilledTonalButton(
                            onClick = { onSelectMachine(machine) },
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                            modifier = Modifier.height(34.dp)
                        ) {
                            Text(
                                text = tr(language, "Details", "विवरण", "التفاصيل"),
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
