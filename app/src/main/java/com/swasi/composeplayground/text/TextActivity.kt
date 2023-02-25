package com.swasi.composeplayground.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.swasi.composeplayground.R

val fontFamily = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Thin),
    Font(R.font.robot_thin, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Light),
    Font(R.font.roboto_light, FontWeight.ExtraLight),
    Font(R.font.roboto_italic, FontWeight.ExtraBold),
    Font(R.font.roboto_bold_italic, FontWeight.SemiBold),
    Font(R.font.roboto_bold, FontWeight.Thin),
    Font(R.font.roboto_light_italic, FontWeight.Medium),
    Font(R.font.roboto_thin_italic, FontWeight.Bold)
)

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0XFF101010))
            ) {
                Text(
                    text = "Jetpack Compose Text",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fontFamily
                )
            }
        }
    }
}


@Preview
@Composable
fun TextPreviewWithTextSpan() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFF101010))
    ) {
        Text(
            text = buildAnnotatedString {
               withStyle(style = SpanStyle(
                   color = Color.Green,
                   fontSize = 50.sp
               )){
                   append("J")
               }
                append("etpack ")
                withStyle(style = SpanStyle(
                    color = Color.Green,
                    fontSize = 50.sp
                )){
                    append("C")
                }
                append("ompose ")
            },
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Preview
@Composable
fun TextPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFF101010))
    ) {
        Text(
            text = "Jetpack Compose",
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }
}
