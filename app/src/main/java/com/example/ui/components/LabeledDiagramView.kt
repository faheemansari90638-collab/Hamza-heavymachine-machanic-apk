package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.DiagramPoint
import com.example.model.tr
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

/**
 * Interactive labeled mechanical diagram canvas supporting EN / HI / AR
 */
@Composable
fun LabeledDiagramView(
    partName: String,
    diagramPoints: List<DiagramPoint>,
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.6f), RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = tr(
                        language,
                        "Technical Labeled Diagram",
                        "तकनीकी लेबल डायग्राम",
                        "الرسم التوضيحي المرقم"
                    ),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = JcbYellow
                )
                Text(
                    text = "CAD Blueprint",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .background(JcbBlack, RoundedCornerShape(12.dp))
                    .padding(8.dp)
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val w = size.width
                    val h = size.height

                    val gridColor = Color(0xFF232B38)
                    for (x in 0..w.toInt() step 40) {
                        drawLine(gridColor, Offset(x.toFloat(), 0f), Offset(x.toFloat(), h), 1f)
                    }
                    for (y in 0..h.toInt() step 40) {
                        drawLine(gridColor, Offset(0f, y.toFloat()), Offset(w, y.toFloat()), 1f)
                    }

                    val path = Path().apply {
                        moveTo(w * 0.15f, h * 0.70f)
                        lineTo(w * 0.30f, h * 0.30f)
                        lineTo(w * 0.60f, h * 0.25f)
                        lineTo(w * 0.85f, h * 0.55f)
                        lineTo(w * 0.80f, h * 0.80f)
                        lineTo(w * 0.45f, h * 0.85f)
                        close()
                    }
                    drawPath(path = path, color = JcbYellow.copy(alpha = 0.15f))
                    drawPath(path = path, color = JcbYellow, style = Stroke(width = 3.5f))

                    drawLine(
                        color = Color(0xFFFF9800),
                        start = Offset(w * 0.30f, h * 0.30f),
                        end = Offset(w * 0.75f, h * 0.75f),
                        strokeWidth = 3f
                    )
                    drawLine(
                        color = Color(0xFF64B5F6),
                        start = Offset(w * 0.45f, h * 0.85f),
                        end = Offset(w * 0.45f, h * 0.20f),
                        strokeWidth = 2.5f
                    )

                    drawCircle(color = Color(0xFF9E9E9E), radius = 26f, center = Offset(w * 0.52f, h * 0.52f))
                    drawCircle(color = JcbYellow, radius = 14f, center = Offset(w * 0.52f, h * 0.52f))
                }

                val positions = listOf(
                    Pair(0.18f, 0.25f),
                    Pair(0.70f, 0.20f),
                    Pair(0.48f, 0.46f),
                    Pair(0.75f, 0.72f)
                )

                diagramPoints.take(4).forEachIndexed { idx, point ->
                    val (xRel, yRel) = positions.getOrElse(idx) { Pair(0.5f, 0.5f) }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = (xRel * 260).dp, top = (yRel * 120).dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(26.dp)
                                .background(JcbYellow, CircleShape)
                                .border(2.dp, JcbBlack, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${point.number}",
                                fontWeight = FontWeight.Black,
                                fontSize = 13.sp,
                                color = JcbBlack
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            diagramPoints.forEach { point ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Box(
                        modifier = Modifier
                            .size(22.dp)
                            .background(JcbYellow, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${point.number}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = JcbBlack
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = point.label(language),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = point.description(language),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}
