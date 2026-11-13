package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.ExplodedPartNode
import com.example.model.tr
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

/**
 * Exploded View CAD Diagram Canvas displaying mechanical assembly breakdown
 */
@Composable
fun ExplodedAssemblyDiagramView(
    title: String,
    parts: List<ExplodedPartNode>,
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, JcbYellow.copy(alpha = 0.5f), RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = tr(language, "Exploded Assembly Diagram", "एक्सप्लोडेड पार्ट्स आरेख (CAD Schematic)", "مخطط التجميع المفصل"),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = JcbYellow
                )
                Text(
                    text = "OEM Blueprint",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Exploded CAD Canvas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFF0F141C), RoundedCornerShape(12.dp))
                    .border(1.dp, Color(0xFF1E2A38), RoundedCornerShape(12.dp))
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val w = size.width
                    val h = size.height

                    // Blueprint grid
                    for (x in 0..w.toInt() step 30) {
                        drawLine(Color(0xFF182230), Offset(x.toFloat(), 0f), Offset(x.toFloat(), h), 1f)
                    }
                    for (y in 0..h.toInt() step 30) {
                        drawLine(Color(0xFF182230), Offset(0f, y.toFloat()), Offset(w, y.toFloat()), 1f)
                    }

                    // Main Exploded Center Axis (Dashed Centerline)
                    drawLine(
                        color = Color(0xFF4FC3F7),
                        start = Offset(w * 0.12f, h * 0.5f),
                        end = Offset(w * 0.88f, h * 0.5f),
                        strokeWidth = 2f
                    )

                    // Node 1: Outer Housing / Kingpost Casting
                    drawRect(
                        color = Color(0xFF37474F),
                        topLeft = Offset(w * 0.15f, h * 0.25f),
                        size = androidx.compose.ui.geometry.Size(60f, 100f)
                    )
                    drawRect(
                        color = JcbYellow,
                        topLeft = Offset(w * 0.15f, h * 0.25f),
                        size = androidx.compose.ui.geometry.Size(60f, 100f),
                        style = Stroke(width = 2f)
                    )

                    // Node 2: Top Pin
                    drawRect(
                        color = Color(0xFFB0BEC5),
                        topLeft = Offset(w * 0.35f, h * 0.35f),
                        size = androidx.compose.ui.geometry.Size(40f, 60f)
                    )

                    // Node 3: Bronze Bush
                    drawCircle(
                        color = Color(0xFFFFB300),
                        radius = 22f,
                        center = Offset(w * 0.55f, h * 0.5f),
                        style = Stroke(width = 6f)
                    )

                    // Node 4: Hydraulic Slew / Ram Rod End
                    drawCircle(
                        color = Color(0xFF90A4AE),
                        radius = 26f,
                        center = Offset(w * 0.75f, h * 0.5f)
                    )
                    drawCircle(
                        color = JcbBlack,
                        radius = 12f,
                        center = Offset(w * 0.75f, h * 0.5f)
                    )
                }

                // Numbered Callout Balloons (1, 2, 3, 4, 5)
                val calloutOffsets = listOf(
                    Pair(0.18f, 0.15f),
                    Pair(0.38f, 0.20f),
                    Pair(0.53f, 0.22f),
                    Pair(0.73f, 0.22f)
                )

                calloutOffsets.take(parts.size).forEachIndexed { idx, pos ->
                    val (xRel, yRel) = pos
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                start = (xRel * 280).dp,
                                top = (yRel * 160).dp
                            )
                    ) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(JcbYellow, CircleShape)
                                .border(1.5.dp, JcbBlack, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${idx + 1}",
                                fontWeight = FontWeight.Black,
                                fontSize = 12.sp,
                                color = JcbBlack
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Exploded Parts Table with OEM Part Numbers
            Text(
                text = tr(language, "Exploded Bill of Materials (BOM):", "पार्ट्स लिस्ट एवं पार्ट नंबर (BOM):", "قائمة القطع وأرقامها:"),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = JcbYellow
            )

            Spacer(modifier = Modifier.height(6.dp))
            parts.forEach { node ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .background(JcbYellow, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${node.itemNumber}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.sp,
                                color = JcbBlack
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = node.partName(language),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold
                            )
                            node.torqueOrFitmentSpec?.let { spec ->
                                Text(
                                    text = spec,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }

                    Surface(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "P/N: ${node.partNumber}",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = JcbYellow,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }
    }
}
