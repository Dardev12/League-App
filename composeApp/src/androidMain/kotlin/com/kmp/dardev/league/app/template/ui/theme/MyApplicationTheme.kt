package com.kmp.dardev.league.app.template.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette =
    darkColorScheme(
        primary = lightBackground,
        background = darkBackground,
        surface = lightBackground,
        onPrimary = darkForeground,
        onSecondary = Color.White,
        onBackground = darkForeground,
        onSurface = darkForeground,
    )

private val LightColorPalette =
    lightColorScheme(
        primary = darkBackground,
        background = lightBackground,
        surface = darkBackground,
        onPrimary = lightBackground,
        onSecondary = Color.Black,
        onBackground = lightForeground,
        onSurface = lightForeground,
    )

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors =
        if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = Shapes,
        content = content,
    )
}
