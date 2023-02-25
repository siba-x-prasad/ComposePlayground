package com.swasi.composeplayground.components

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.swasi.composeplayground.R
import com.swasi.composeplayground.ui.theme.AppFonts

@Composable
fun AppText(
    text: String,
    textColor: Color = Color.Red,
    size: TextUnit = 12.sp,
    fontWeight: FontWeight = FontWeight.Light,
    maxLines: Int = 1,
//    fontFamily: FontFamily = AppFonts
) {
    Text(
        text = text,
        color = textColor,
        fontSize = size,
        fontWeight = fontWeight,
        maxLines = maxLines
    )
}

@Composable
fun AppTextTitle(
    text: String,
    textColor: Color = Color.Black,
    size: TextUnit = 15.sp,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Text(text = text, color = textColor, fontSize = size, fontWeight = fontWeight)
}

@Composable
fun OverflowedText() {
    Text("Hello Compose ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
}

@Composable
fun SelectableText() {
    SelectionContainer {
        Text("This text is selectable")
    }
}

@Preview(name = "Text1")
@Composable
fun appTextPreview() {
    AppText("Sibaprasad")
}


