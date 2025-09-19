package com.github.bqtankiet.layoutgridsystem.guideline

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import com.github.bqtankiet.layoutgridsystem.common.Padding
import com.github.bqtankiet.layoutgridsystem.common.Padding.toPx

/**
 * Composable that draws a guideline system overlay for UI layout debugging.
 * Displays screen padding, top bar, navigation bar, FAB guideline, and center lines.
 */
@Composable
fun GuidelineSystem() {
    // Constants for drawing
    val lineStroke = GuidelineConfig.LINE_STROKE
    val edgeBackgroundAlpha = GuidelineConfig.ALPHA

    // Device dimensions and padding
    val topPadding = Padding.System.top.toPx()
    val bottomPadding = Padding.System.bottom.toPx()
    val screenPadding = Padding.SCREEN.toPx()

    // Calculated dimensions
    val topBarHeight = GuidelineConfig.TOP_BAR_HEIGHT.toPx()
    val navHeight = GuidelineConfig.NAVIGATION_HEIGHT.toPx()
    val navPadding = GuidelineConfig.NAVIGATION_PADDING.toPx()
    val fabPadding = GuidelineConfig.FLOATING_BUTTON_TO_BOTTOM.toPx()

    Canvas(modifier = Modifier.fillMaxSize()) {
        val deviceWidth = size.width
        val deviceHeight = size.height
        val contentWidth = deviceWidth - 2 * screenPadding
        val contentHeight = deviceHeight - topPadding - bottomPadding

        drawEdgeBackground(
            edgeBackgroundAlpha,
            screenPadding,
            topPadding,
            contentWidth,
            contentHeight
        )
        drawTopBar(topPadding, deviceWidth, topBarHeight, lineStroke)
        drawFabGuideline(fabPadding, bottomPadding, deviceWidth, deviceHeight)
        drawNavigationBar(
            bottomPadding,
            navPadding,
            deviceWidth,
            deviceHeight,
            navHeight,
            lineStroke
        )
        drawCenterLines(deviceWidth, deviceHeight)
        drawPaddingGuidelines(
            screenPadding,
            topPadding,
            deviceWidth,
            size.height - bottomPadding,
            contentWidth,
            contentHeight,
            lineStroke
        )
    }
}

/**
 * Draws the semi-transparent edge background with a clear content area.
 */
private fun DrawScope.drawEdgeBackground(
    alpha: Float,
    screenPadding: Float,
    topPadding: Float,
    contentWidth: Float,
    contentHeight: Float
) {
    drawIntoCanvas { canvas ->
        canvas.saveLayer(bounds = Rect(0f, 0f, size.width, size.height), paint = Paint())
        drawRect(color = Color.Red.copy(alpha = alpha), size = size)
        drawRect(
            color = Color.Transparent,
            topLeft = Offset(screenPadding, topPadding),
            size = Size(contentWidth, contentHeight),
            blendMode = BlendMode.Clear
        )
        canvas.restore()
    }
}

/**
 * Draws the top app bar outline.
 */
private fun DrawScope.drawTopBar(
    topPadding: Float,
    deviceWidth: Float,
    topBarHeight: Float,
    stroke: Stroke
) {
    drawRect(
        style = stroke,
        color = Color.Green,
        size = Size(deviceWidth, topBarHeight),
        topLeft = Offset(0f, topPadding)
    )
}

/**
 * Draws the floating action button guideline.
 */
private fun DrawScope.drawFabGuideline(
    fabPadding: Float,
    bottomPadding: Float,
    deviceWidth: Float,
    deviceHeight: Float
) {
    drawLine(
        color = Color.Magenta,
        start = Offset(0f, deviceHeight - fabPadding - bottomPadding),
        end = Offset(deviceWidth, deviceHeight - fabPadding - bottomPadding),
        strokeWidth = 2f
    )
}

/**
 * Draws the navigation bar outline.
 */
private fun DrawScope.drawNavigationBar(
    bottomPadding: Float,
    navPadding: Float,
    deviceWidth: Float,
    deviceHeight: Float,
    navHeight: Float,
    stroke: Stroke
) {
    drawRect(
        color = Color.Green,
        topLeft = Offset(0f, deviceHeight - navHeight - bottomPadding - navPadding),
        size = Size(deviceWidth, navHeight),
        style = stroke
    )
}

/**
 * Draws vertical and horizontal center lines.
 */
private fun DrawScope.drawCenterLines(
    deviceWidth: Float,
    deviceHeight: Float
) {
    // Vertical center line
    drawLine(
        color = Color.Red,
        start = Offset(deviceWidth / 2, 0f),
        end = Offset(deviceWidth / 2, deviceHeight),
        strokeWidth = 2f
    )
    // Horizontal center line
    drawLine(
        color = Color.Red,
        start = Offset(0f, deviceHeight / 2),
        end = Offset(deviceWidth, deviceHeight / 2),
        strokeWidth = 2f
    )
}

/**
 * Draws padding guidelines for left, right, top, and bottom.
 */
private fun DrawScope.drawPaddingGuidelines(
    screenPadding: Float,
    topPadding: Float,
    deviceWidth: Float,
    deviceHeight: Float,
    contentWidth: Float,
    contentHeight: Float,
    stroke: Stroke
) {
    drawLine(
        color = Color.Red,
        start = Offset(screenPadding, 0f),
        end = Offset(screenPadding, deviceHeight),
        strokeWidth = 2f
    )
    drawLine(
        color = Color.Red,
        start = Offset(deviceWidth - screenPadding, 0f),
        end = Offset(deviceWidth - screenPadding, deviceHeight),
        strokeWidth = 2f
    )
    drawLine(
        color = Color.Red,
        start = Offset(0f, topPadding),
        end = Offset(deviceWidth, topPadding),
        strokeWidth = 2f
    )
    drawLine(
        color = Color.Red,
        start = Offset(0f, deviceHeight),
        end = Offset(deviceWidth, deviceHeight),
        strokeWidth = 2f
    )

//    // Left + Right padding
//    drawRect(
//        color = Color.Red,
//        topLeft = Offset(screenPadding, 0f),
//        size = Size(contentWidth, deviceHeight),
//        style = stroke
//    )
    // Top + Bottom padding
//    drawRect(
//        style = stroke,
//        color = Color.Red,
//        size = Size(deviceWidth, contentHeight),
//        topLeft = Offset(0f, topPadding)
//    )
}

/**
 * Draws the screen edge outline.
 */
private fun DrawScope.drawScreenEdge(
    deviceWidth: Float,
    deviceHeight: Float,
    topPadding: Float,
    stroke: Stroke
) {
    drawRect(
        style = stroke,
        color = Color.Red,
        size = Size(deviceWidth, deviceHeight),
        topLeft = Offset(0f, topPadding)
    )
}

/**
 * Preview composable for GuidelineSystem.
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewGuidelineSystem() {
    GuidelineSystem()
}