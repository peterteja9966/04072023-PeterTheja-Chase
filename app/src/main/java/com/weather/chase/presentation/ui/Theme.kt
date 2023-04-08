package com.weather.chase.presentation.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.weather.chase.presentation.theme.Typography
import com.weather.chase.ui.theme.Shapes

@Composable
fun WeatherAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}