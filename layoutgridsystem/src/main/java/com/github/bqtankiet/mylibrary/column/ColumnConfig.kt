package com.github.bqtankiet.layoutgridsystem.column

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ColumnConfig(
    val count: Int = 4,
    val color: Color = Color.Magenta.copy(.1f),
    val gutter: Dp = 16.dp,
    val margin: Dp = 16.dp
)
