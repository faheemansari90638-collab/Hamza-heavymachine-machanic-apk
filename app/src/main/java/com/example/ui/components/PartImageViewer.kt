package com.example.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ZoomIn
import androidx.compose.material.icons.filled.ZoomOut
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.model.AppLanguage
import com.example.model.JcbPart
import com.example.model.tr
import com.example.ui.theme.JcbBlack
import com.example.ui.theme.JcbYellow

/**
 * Clean White Studio Photo Showcase Card for an individual JCB Part.
 * Displays a single isolated HD part photo on white background, labeled cleanly with
 * English, Hindi, and Arabic names, and opens a full-screen zoomable viewer on tap.
 */
@Composable
fun PartStudioPhotoCard(
    part: JcbPart,
    language: AppLanguage,
    onOpenFullScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, JcbYellow.copy(alpha = 0.6f), RoundedCornerShape(16.dp))
            .testTag("part_studio_photo_card"),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            // Pure white studio showcase frame for isolated single-part HD image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
                    .background(Color.White)
                    .clickable(onClick = onOpenFullScreen)
                    .padding(12.dp)
                    .testTag("open_fullscreen_part_image")
            ) {
                Image(
                    painter = painterResource(id = part.imageResId),
                    contentDescription = "${part.nameEn} - ${part.nameHi} - ${part.nameAr}",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )

                // Top-left verified part badge
                Surface(
                    color = JcbBlack.copy(alpha = 0.85f),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.align(Alignment.TopStart)
                ) {
                    Text(
                        text = part.system.title(language),
                        color = JcbYellow,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                // Bottom-end Zoom indicator button
                Surface(
                    color = JcbYellow,
                    shape = RoundedCornerShape(20.dp),
                    shadowElevation = 3.dp,
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ZoomIn,
                            contentDescription = tr(language, "Full-screen Zoom", "ज़ूम करें", "تكبير الصورة"),
                            tint = JcbBlack,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = tr(language, "HD Zoom", "ज़ूम देखें", "تكبير HD"),
                            color = JcbBlack,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Trilingual Part Label Footer directly under the photo
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 10.dp)
            ) {
                Text(
                    text = part.nameEn,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = part.nameHi,
                        style = MaterialTheme.typography.bodySmall,
                        color = JcbYellow,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = part.nameAr,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

/**
 * Full-Screen Interactive Pinch-to-Zoom, Double-Tap & Pan HD Part Image Dialog
 */
@Composable
fun FullScreenPartImageDialog(
    @DrawableRes imageResId: Int,
    partNameEn: String,
    partNameHi: String,
    partNameAr: String,
    partNumber: String,
    language: AppLanguage,
    onDismiss: () -> Unit
) {
    var scale by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .testTag("fullscreen_part_image_dialog"),
            color = Color(0xFF0E1116)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(WindowInsets.systemBars)
            ) {
                // Header with Part Names & Close
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(JcbBlack)
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = when (language) {
                                AppLanguage.ENGLISH -> partNameEn
                                AppLanguage.HINDI -> "$partNameHi ($partNameEn)"
                                AppLanguage.ARABIC -> "$partNameAr ($partNameEn)"
                            },
                            color = JcbYellow,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "P/N: $partNumber",
                            color = Color.White.copy(alpha = 0.75f),
                            fontSize = 11.sp
                        )
                    }

                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .size(48.dp)
                            .testTag("close_fullscreen_image")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = tr(language, "Close", "बंद करें", "إغلاق"),
                            tint = Color.White
                        )
                    }
                }

                // Pure white interactive zoomable canvas stage
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color.White)
                        .clip(RoundedCornerShape(0.dp))
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onDoubleTap = {
                                    if (scale > 1.2f) {
                                        scale = 1f
                                        offset = Offset.Zero
                                    } else {
                                        scale = 2.5f
                                    }
                                }
                            )
                        }
                        .pointerInput(Unit) {
                            detectTransformGestures { _, pan, zoom, _ ->
                                val newScale = (scale * zoom).coerceIn(1f, 5f)
                                scale = newScale
                                if (newScale > 1f) {
                                    offset = Offset(offset.x + pan.x, offset.y + pan.y)
                                } else {
                                    offset = Offset.Zero
                                }
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = partNameEn,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .graphicsLayer(
                                scaleX = scale,
                                scaleY = scale,
                                translationX = offset.x,
                                translationY = offset.y
                            )
                    )
                }

                // Bottom Zoom Control Bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(JcbBlack)
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = tr(
                            language,
                            "Pinch or double-tap to zoom (${String.format("%.1f", scale)}x)",
                            "ज़ूम के लिए पिंच या डबल-टैप करें (${String.format("%.1f", scale)}x)",
                            "اضغط مرتين أو قرّب للتكبير (${String.format("%.1f", scale)}x)"
                        ),
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f)
                    )

                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        IconButton(
                            onClick = {
                                val next = (scale - 0.7f).coerceAtLeast(1f)
                                scale = next
                                if (next <= 1f) offset = Offset.Zero
                            },
                            modifier = Modifier
                                .size(42.dp)
                                .background(Color.White.copy(alpha = 0.12f), CircleShape)
                        ) {
                            Icon(Icons.Default.ZoomOut, contentDescription = "Zoom Out", tint = Color.White)
                        }

                        IconButton(
                            onClick = {
                                scale = 1f
                                offset = Offset.Zero
                            },
                            modifier = Modifier
                                .size(42.dp)
                                .background(Color.White.copy(alpha = 0.12f), CircleShape)
                        ) {
                            Icon(Icons.Default.Refresh, contentDescription = "Reset", tint = JcbYellow)
                        }

                        IconButton(
                            onClick = {
                                scale = (scale + 0.7f).coerceAtMost(5f)
                            },
                            modifier = Modifier
                                .size(42.dp)
                                .background(JcbYellow, CircleShape)
                        ) {
                            Icon(Icons.Default.ZoomIn, contentDescription = "Zoom In", tint = JcbBlack)
                        }
                    }
                }
            }
        }
    }
}
