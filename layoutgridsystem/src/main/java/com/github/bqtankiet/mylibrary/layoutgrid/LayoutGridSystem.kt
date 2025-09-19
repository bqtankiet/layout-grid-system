package com.github.bqtankiet.layoutgridsystem.layoutgrid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.bqtankiet.layoutgridsystem.column.ColumnConfig
import com.github.bqtankiet.layoutgridsystem.column.ColumnSystem
import com.github.bqtankiet.layoutgridsystem.guideline.GuidelineConfig
import com.github.bqtankiet.layoutgridsystem.guideline.GuidelineSystem
import com.github.bqtankiet.layoutgridsystem.row.RowConfig
import com.github.bqtankiet.layoutgridsystem.row.RowSystem

@Composable
fun LayoutGridSystem(
    modifier: Modifier = Modifier,
    column: ColumnConfig = ColumnConfig(),
    row: RowConfig = RowConfig(),
    showGuideline: Boolean = GuidelineConfig.VISIBLE,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ) {
        // columns
        if (column.count > 0) ColumnSystem(column)
        // rows
        if (row.height > 0.dp) RowSystem(row)
        // guidelines
        if (showGuideline) GuidelineSystem()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewGuideline() {
    LayoutGridSystem()
}
