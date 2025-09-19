package com.github.bqtankiet.layoutgridsystem.row

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
import kotlin.math.ceil

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun RowSystem(
    config: RowConfig = RowConfig(),
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(top = config.offset)
    ) {
        val totalRowHeight = config.height + config.gutter
        val rows = ceil(maxHeight / totalRowHeight).toInt()

        Canvas(modifier = Modifier.fillMaxSize()) {
            val rowHeightPx = config.height.toPx()
            val rowGutterPx = config.gutter.toPx()

            repeat(rows) { i ->
                val top = i * (rowHeightPx + rowGutterPx)
                drawRect(
                    color = config.color,
                    topLeft = Offset(0f, top),
                    size = Size(size.width, rowHeightPx)
                )
            }
        }
    }
}
