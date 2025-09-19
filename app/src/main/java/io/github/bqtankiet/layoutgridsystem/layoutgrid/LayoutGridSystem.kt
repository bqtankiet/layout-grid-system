package io.github.bqtankiet.layoutgridsystem.layoutgrid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.bqtankiet.layoutgridsystem.column.ColumnSystem
import io.github.bqtankiet.layoutgridsystem.guideline.GuidelineSystem
import io.github.bqtankiet.layoutgridsystem.row.RowSystem

@Composable
fun LayoutGridSystem(
    modifier: Modifier = Modifier,
    config: LayoutGridConfig = LayoutGridConfig(),
) {
    Box( // outer line (red)
        modifier = modifier
            .fillMaxSize()
//            .padding(DeviceProperty.Padding.all)
            .background(Color.Transparent)
    ) {
        // columns
        if (config.columns > 0) ColumnSystem(config.columns, config.columnGutter)
        // rows
        if (config.rowHeight > 0.dp) RowSystem(config.rowHeight, config.rowGutter)
        // guidelines
        if (config.showGuideline) GuidelineSystem()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewGuideline() {
    val layoutGridConfig = LayoutGridConfig(
        showGuideline = true
    )
    LayoutGridSystem(config = layoutGridConfig)
}
