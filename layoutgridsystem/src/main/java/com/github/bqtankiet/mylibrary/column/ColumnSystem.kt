package com.github.bqtankiet.layoutgridsystem.column

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ColumnSystem(
    config: ColumnConfig = ColumnConfig(),
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = config.margin)
    ) {
        if (config.count <= 0) return@BoxWithConstraints

        val totalGutter = config.gutter * (config.count - 1)
        val columnWidth = (maxWidth - totalGutter) / config.count

        Canvas(modifier = Modifier.fillMaxSize()) {
            val colWidthPx = columnWidth.toPx()
            val gutterPx = config.gutter.toPx()

            repeat(config.count) { i ->
                val left = i * (colWidthPx + gutterPx)
                drawRect(
                    color = config.color,
                    topLeft = Offset(left, 0f),
                    size = Size(colWidthPx, size.height)
                )
            }
        }
    }
}
