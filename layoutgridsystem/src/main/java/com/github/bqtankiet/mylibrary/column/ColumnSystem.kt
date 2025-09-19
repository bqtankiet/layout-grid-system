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
import androidx.compose.ui.unit.Dp
import com.github.bqtankiet.layoutgridsystem.common.Padding


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ColumnSystem(
    columns: Int,
    colGutter: Dp
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Padding.SCREEN)
    ) {
        if (columns <= 0) return@BoxWithConstraints

        val totalGutter = colGutter * (columns - 1)
        val columnWidth = (maxWidth - totalGutter) / columns

        Canvas(modifier = Modifier.fillMaxSize()) {
            val colWidthPx = columnWidth.toPx()
            val gutterPx = colGutter.toPx()

            repeat(columns) { i ->
                val left = i * (colWidthPx + gutterPx)
                drawRect(
                    color = ColumnConfig.COLOR,
                    topLeft = Offset(left, 0f),
                    size = Size(colWidthPx, size.height)
                )
            }
        }
    }
}
