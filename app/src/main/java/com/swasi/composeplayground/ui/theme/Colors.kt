package com.swasi.composeplayground.ui.theme

import androidx.compose.ui.graphics.Color

object Colors {
    val purple200 = Color(0xFFBB86FC)
    val purple500 = Color(0xFF6200EE)
    val purple700 = Color(0xFF3700B3)
    val teal200 = Color(0xFF03DAC5)
    val teal700 = Color(0xFF018786)

    val black = Color(0xFF000000)
    val white = Color(0xFFFFFFFF)
    val red = Color(0xFFFF0000)
    val green = Color(0xFF00FF00)
    val blue = Color(0xFF0000FF)

    fun getColorFromHex(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#$colorString"))
    }

}