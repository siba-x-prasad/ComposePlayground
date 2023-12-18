package swasi.android.component

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import swasi.android.component.theme.LESSON_HEADER_COLOR

val boldRegex = Regex("(?<!\\*)\\*\\*(?!\\*).*?(?<!\\*)\\*\\*(?!\\*)")

@Composable
fun LessonHeader(text: String, modifier: Modifier = Modifier, textAlign: TextAlign? = null) {

    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 6.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        textAlign = textAlign,
        text = text,
        color = LESSON_HEADER_COLOR
    )
}

@Composable
fun LessonHeaderWithStringRes(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    val resources = LocalContext.current.resources
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 6.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        textAlign = textAlign,
        text = resources.getText(text).toString()
    )
}

/**
 * [Text] for describing tutorial contents for specific section which ads bold to first
 * 3 chars which should be as 1- and turns any substring that is between pair of **
 *
 */
@Composable
fun StyleableLessonText(text: String, modifier: Modifier = Modifier, bullets: Boolean = true) {

    var results: MatchResult? = boldRegex.find(text)
    val boldIndexes = mutableListOf<Pair<Int, Int>>()
    val keywords = mutableListOf<String>()

    var finalText = text

    while (results != null) {
        keywords.add(results.value)
        results = results.next()
    }

    keywords.forEach { keyword ->
        val newKeyWord = keyword.removeSurrounding("**")
        finalText = finalText.replace(keyword, newKeyWord)
        val indexOf = finalText.indexOf(newKeyWord)
        boldIndexes.add(Pair(indexOf, indexOf + newKeyWord.length))
    }

    val annotatedString = buildAnnotatedString {

        append(finalText)

        if (bullets) {
            addStyle(style = SpanStyle(fontWeight = FontWeight.Bold), start = 0, end = 3)
        }

        // Add bold style to keywords that has to be bold
        boldIndexes.forEach {
            addStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff64B5F6),
                    fontSize = 15.sp

                ),
                start = it.first,
                end = it.second
            )

        }
    }

    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 12.dp),
        fontSize = 16.sp,
        text = annotatedString
    )
}

@Composable
fun LessonText2(text: String, modifier: Modifier = Modifier) {

    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {

        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            color = Color.Gray,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
        )
    }
}

@Preview
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C)
@Composable
private fun LessonTextPreview() {
    StyleableLessonText("Sample text")
}