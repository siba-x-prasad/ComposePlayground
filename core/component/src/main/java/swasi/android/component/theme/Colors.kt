package swasi.android.component.theme

import androidx.compose.ui.graphics.Color

object Colors {
    val purple200 = Color(0xFFBB86FC)
    val purple500 = Color(0xFF6200EE)
    val purple700 = Color(0xFF3700B3)
    val teal200 = Color(0xFF03DAC5)
    val teal700 = Color(0xFF018786)
    val white = Color(0xFFFFFFFF)

    fun getColorFromHex(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#$colorString"))
    }

}