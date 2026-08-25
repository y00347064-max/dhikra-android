package com.dhikra.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = LuxuryGold,
    secondary = DeepEmerald,
    tertiary = SubtleTurquoise,
    background = MidnightNavy,
    surface = DarkSurface,
    onBackground = SoftIvory,
    onSurface = SoftIvory,
    onPrimary = MidnightNavy,
    onSecondary = SoftIvory,
    onTertiary = SoftIvory,
    error = ErrorRed,
    onError = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = LightGold,
    secondary = LightEmerald,
    tertiary = SubtleTurquoise,
    background = WhiteBackground,
    surface = LightIvory,
    onBackground = DarkText,
    onSurface = DarkText,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    error = ErrorRed,
    onError = Color.White
)

import androidx.compose.ui.graphics.Color

@Composable
fun DhikraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = dhikraTypography,
        content = content
    )
}
