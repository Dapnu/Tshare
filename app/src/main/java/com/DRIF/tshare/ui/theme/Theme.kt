package com.DRIF.tshare.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.annotation.VisibleForTesting

@VisibleForTesting
val LightColorPalette = lightColors(
    primary = Green40,
    onPrimary = Color.White,
    secondary = DarkGreen40,
    onSecondary = Color.White,
    error = Red40,
    onError = Color.White,
    background = DarkGreenGray99,
    onBackground = DarkGreenGray10,
    surface = DarkGreenGray99,
    onSurface = DarkGreenGray10,
)


@VisibleForTesting
val DarkColorPalette = darkColors(
    primary = Green80,
    onPrimary = Green20,
    secondary = DarkGreen80,
    onSecondary = DarkGreen20,
    error = Red80,
    onError = Red20,
    background = DarkGreenGray10,
    onBackground = DarkGreenGray90,
    surface = DarkGreenGray10,
    onSurface = DarkGreenGray90,
)

@Composable
fun TshareTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}