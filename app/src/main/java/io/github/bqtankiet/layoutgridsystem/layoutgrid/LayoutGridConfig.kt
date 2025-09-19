package io.github.bqtankiet.layoutgridsystem.layoutgrid

import androidx.compose.ui.unit.Dp
import io.github.bqtankiet.layoutgridsystem.column.ColumnConfig
import io.github.bqtankiet.layoutgridsystem.guideline.GuidelineConfig
import io.github.bqtankiet.layoutgridsystem.row.RowConfig

data class LayoutGridConfig(
    val showGuideline: Boolean = GuidelineConfig.VISIBLE,
    val columns: Int = ColumnConfig.COLUMNS,
    val columnGutter: Dp = ColumnConfig.GUTTER,
    val rowHeight: Dp = RowConfig.HEIGHT,
    val rowGutter: Dp = RowConfig.GUTTER,
)

