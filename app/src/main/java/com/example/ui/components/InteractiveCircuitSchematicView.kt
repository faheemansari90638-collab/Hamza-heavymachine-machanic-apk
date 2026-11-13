package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.tr
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

/**
 * Interactive Electrical Circuit Schematic Canvas with Zoom, Pan & Trace
 */
@Composable
fun InteractiveCircuitSchematicView(
    circuitTitle: String,
    machineModel: String,
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

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
                Column {
                    Text(
                        text = tr(language, "HD Electrical Schematic (Zoom & Pan)", "HD इलेक्ट्रिकल सर्किट आरेख (ज़ूम व पैन)", "المخطط الكهربائي عالي الدقة (تكبير وتحريك)"),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = JcbYellow
                    )
                    Text(
                        text = "$circuitTitle • $machineModel",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = {
                        scale = 1f
                        offset = Offset.Zero
                    },
                    modifier = Modifier.testTag("reset_schematic_zoom")
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Reset Zoom",
                        tint = JcbYellow
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Schematic Canvas Box with interactive pinch-to-zoom and pan
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .background(Color(0xFF0F141C), RoundedCornerShape(12.dp))
                    .border(1.dp, Color(0xFF1E2A38), RoundedCornerShape(12.dp))
                    .pointerInput(Unit) {
                        detectTransformGestures { _, pan, zoom, _ ->
                            scale = (scale * zoom).coerceIn(0.7f, 3.5f)
                            offset = Offset(offset.x + pan.x, offset.y + pan.y)
                        }
                    }
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val w = size.width
                    val h = size.height

                    // Center & apply zoom transformation
                    val cx = w / 2f + offset.x
                    val cy = h / 2f + offset.y

                    // Draw Engineering Grid Lines
                    val gridStep = 30f * scale
                    val startX = (offset.x % gridStep)
                    val startY = (offset.y % gridStep)
                    for (x in 0..(w / gridStep).toInt() + 1) {
                        drawLine(
                            color = Color(0xFF16212E),
                            start = Offset(startX + x * gridStep, 0f),
                            end = Offset(startX + x * gridStep, h),
                            strokeWidth = 1f
                        )
                    }
                    for (y in 0..(h / gridStep).toInt() + 1) {
                        drawLine(
                            color = Color(0xFF16212E),
                            start = Offset(0f, startY + y * gridStep),
                            end = Offset(w, startY + y * gridStep),
                            strokeWidth = 1f
                        )
                    }

                    // 1. BATTERY (Left Node)
                    val batX = cx - 180f * scale
                    val batY = cy
                    drawRect(
                        color = Color(0xFFD32F2F),
                        topLeft = Offset(batX - 25f * scale, batY - 30f * scale),
                        size = androidx.compose.ui.geometry.Size(50f * scale, 60f * scale)
                    )
                    // Battery plates symbol
                    drawLine(
                        color = Color.White,
                        start = Offset(batX - 15f * scale, batY - 10f * scale),
                        end = Offset(batX + 15f * scale, batY - 10f * scale),
                        strokeWidth = 3f * scale
                    )
                    drawLine(
                        color = Color.White,
                        start = Offset(batX - 8f * scale, batY + 10f * scale),
                        end = Offset(batX + 8f * scale, batY + 10f * scale),
                        strokeWidth = 3f * scale
                    )

                    // 2. MAIN FUSE (F1 / 40A)
                    val fuseX = cx - 70f * scale
                    val fuseY = cy
                    // Wire from Battery to Fuse (Red +12V Line)
                    drawLine(
                        color = Color(0xFFEF5350),
                        start = Offset(batX + 25f * scale, batY),
                        end = Offset(fuseX - 20f * scale, fuseY),
                        strokeWidth = 3.5f * scale
                    )
                    drawRect(
                        color = Color(0xFFFFB300),
                        topLeft = Offset(fuseX - 20f * scale, fuseY - 15f * scale),
                        size = androidx.compose.ui.geometry.Size(40f * scale, 30f * scale)
                    )

                    // 3. RELAY COIL & CONTACT (Center Node)
                    val relayX = cx + 50f * scale
                    val relayY = cy
                    // Wire from Fuse to Relay 30
                    drawLine(
                        color = Color(0xFFEF5350),
                        start = Offset(fuseX + 20f * scale, fuseY),
                        end = Offset(relayX - 30f * scale, relayY),
                        strokeWidth = 3.5f * scale
                    )
                    drawRect(
                        color = Color(0xFF37474F),
                        topLeft = Offset(relayX - 30f * scale, relayY - 40f * scale),
                        size = androidx.compose.ui.geometry.Size(60f * scale, 80f * scale)
                    )
                    drawRect(
                        color = Color(0xFF78909C),
                        topLeft = Offset(relayX - 30f * scale, relayY - 40f * scale),
                        size = androidx.compose.ui.geometry.Size(60f * scale, 80f * scale),
                        style = Stroke(width = 2f * scale)
                    )

                    // 4. LOAD / STARTER / LIGHT (Right Node)
                    val loadX = cx + 180f * scale
                    val loadY = cy
                    // Switched +12V Wire from Relay 87 to Load (Yellow Wire)
                    drawLine(
                        color = Color(0xFFFDD835),
                        start = Offset(relayX + 30f * scale, relayY),
                        end = Offset(loadX - 25f * scale, loadY),
                        strokeWidth = 3.5f * scale
                    )
                    drawCircle(
                        color = JcbYellow,
                        radius = 25f * scale,
                        center = Offset(loadX, loadY)
                    )
                    drawCircle(
                        color = JcbBlack,
                        radius = 16f * scale,
                        center = Offset(loadX, loadY)
                    )

                    // 5. CHASSIS GROUND RETURN (Black Ground Rail)
                    val groundY = cy + 70f * scale
                    drawLine(
                        color = Color(0xFF616161),
                        start = Offset(batX, batY + 30f * scale),
                        end = Offset(batX, groundY),
                        strokeWidth = 3f * scale
                    )
                    drawLine(
                        color = Color(0xFF616161),
                        start = Offset(loadX, loadY + 25f * scale),
                        end = Offset(loadX, groundY),
                        strokeWidth = 3f * scale
                    )
                    drawLine(
                        color = Color(0xFF424242),
                        start = Offset(batX, groundY),
                        end = Offset(loadX, groundY),
                        strokeWidth = 4f * scale
                    )
                }

                // Interactive Guidance overlay chip
                Surface(
                    color = Color.Black.copy(alpha = 0.75f),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp)
                ) {
                    Text(
                        text = tr(
                            language,
                            "Pinch to zoom | Drag to pan schematic",
                            "ज़ूम करने के लिए पिंच करें | खींचकर पैन करें",
                            "قرّب للتكبير | اسحب لتحريك المخطط"
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Schematic Legend Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                LegendPill("Red: +12V Battery", 0xFFD32F2F)
                LegendPill("Yellow: Switched Load", 0xFFFDD835)
                LegendPill("Black: 0V Ground", 0xFF424242)
            }
        }
    }
}

@Composable
fun LegendPill(label: String, colorHex: Long) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color(colorHex), RoundedCornerShape(2.dp))
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
