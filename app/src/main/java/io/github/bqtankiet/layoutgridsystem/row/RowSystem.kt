package io.github.bqtankiet.layoutgridsystem.row

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Dp
import io.github.bqtankiet.layoutgridsystem.layoutgrid.LayoutGridConfig
import kotlin.math.ceil

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun RowSystem(
    rowHeight: Dp,
    rowGutter: Dp
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize().padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        val totalRowHeight = rowHeight + rowGutter
        val rows = ceil(maxHeight / totalRowHeight).toInt()

        Canvas(modifier = Modifier.fillMaxSize()) {
            val rowHeightPx = rowHeight.toPx()
            val rowGutterPx = rowGutter.toPx()

            repeat(rows) { i ->
                val top = i * (rowHeightPx + rowGutterPx)
                drawRect(
                    color = RowConfig.COLOR,
                    topLeft = Offset(0f, top),
                    size = Size(size.width, rowHeightPx)
                )
            }
        }
    }
}
