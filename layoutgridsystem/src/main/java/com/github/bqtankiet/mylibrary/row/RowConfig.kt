package com.github.bqtankiet.layoutgridsystem.row

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class RowConfig(
    val height: Dp = 16.dp,
    val color: Color = Color.Green.copy(.1f),
    val gutter: Dp = 8.dp,
    val offset: Dp = 0.dp,
)
