package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = JcbYellow,
    onPrimary = JcbBlack,
    primaryContainer = JcbYellowDark,
    onPrimaryContainer = Color.White,
    secondary = JcbYellowLight,
    onSecondary = JcbBlack,
    secondaryContainer = JcbDarkCard,
    onSecondaryContainer = JcbYellow,
    tertiary = JcbAccentOrange,
    onTertiary = Color.White,
    background = JcbBlack,
    onBackground = Color(0xFFECEAE4),
    surface = JcbDarkSurface,
    onSurface = Color(0xFFF2EFE9),
    surfaceVariant = JcbDarkCard,
    onSurfaceVariant = Color(0xFFCCC5B8),
    outline = JcbDividerDark,
    error = JcbWarningRed,
    onError = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = JcbYellowDark,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFECC4),
    onPrimaryContainer = Color(0xFF4A3400),
    secondary = Color(0xFF2C2822),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFEBE6DC),
    onSecondaryContainer = Color(0xFF1E1B15),
    tertiary = JcbAccentOrange,
    onTertiary = Color.White,
    background = JcbLightBg,
    onBackground = Color(0xFF1C1A17),
    surface = JcbLightSurface,
    onSurface = Color(0xFF1C1A17),
    surfaceVariant = Color(0xFFF0ECE3),
    onSurfaceVariant = Color(0xFF4E473F),
    outline = JcbDividerLight,
    error = JcbWarningRed,
    onError = Color.White
)

@Composable
fun JcbTheme(
    darkTheme: Boolean = true, // Default to rugged dark machinery theme
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
