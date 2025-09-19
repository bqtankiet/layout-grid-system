package com.github.bqtankiet.layoutgridsystem.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

object Padding {

    val REGULAR = 8.dp
    val MEDIUM = 16.dp
    val SCREEN = MEDIUM

    object System {

        val systemBars: WindowInsets
            @Composable get() = WindowInsets.Companion.systemBars

        val all: PaddingValues
            @Composable get() = systemBars.asPaddingValues()

        val bottom: Dp
            @Composable get() = all.calculateBottomPadding()

        val top: Dp
            @Composable get() = all.calculateTopPadding()

        val start: Dp
            @Composable get() = all.calculateStartPadding(LayoutDirection.Ltr)

        val end: Dp
            @Composable get() = all.calculateEndPadding(LayoutDirection.Ltr)
    }

    @Composable
    fun Dp.toPx(): Float {
        return with(LocalDensity.current) { this@toPx.toPx() }
    }
}