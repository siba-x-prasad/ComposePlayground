package com.swasi.composeplayground.ui

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Created by Sibaprasad Mohanty on 25/02/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun TextWithSize(label : String, size : TextUnit = 10.sp) {
    Text(label, fontSize = size)
}

@Composable
fun ColorText() {
    Text("Color text", color = Color.Blue)
}

@Composable
fun BoldText() {
    Text("Bold text", fontWeight = FontWeight.Bold)
}

@Composable
fun ItalicText() {
    Text("Italic Text", fontStyle = FontStyle.Italic)
}

@Composable
fun MaxLines() {
    Text("hello ".repeat(50), maxLines = 2)
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

