package com.swasi.composeplayground.mycomponents


import android.view.MotionEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swasi.composeplayground.R
import com.swasi.composeplayground.ui.theme.Colors

@ExperimentalComposeUiApi
@Composable
fun ApButton(
    title: String = "Hello", buttonColor: Color = Color.Red, textColor: Color = Color.White,
    enabled: Boolean = true, onClick: (() -> Unit), radious: Int = 8
) {

    val color = remember { mutableStateOf(Color.Red) }

    Button(
        onClick = onClick,
//        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(radious.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = color.value,
            contentColor = textColor
        ),
        modifier = Modifier
            .padding(8.dp)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        color.value = Colors.teal700
                    }

                    MotionEvent.ACTION_UP -> {
                        color.value = Colors.teal200
                    }
                }
                true
            }
    ) {
        Text(color = textColor, text = title)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun AppButtonEnablePreview() {
    ApButton(onClick = {

    })
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun AppButtonDisablePreview() {
    ApButton(enabled = false, onClick = {})
}


@Composable
fun AppButton(
    title: String = "Button",
    onClick: (() -> Unit),
    enabled: Boolean = true,
    radious: Int = 5,
    textColor: Color = Color.White,
    modifier: Modifier
) {
    Button(
        onClick = onClick, shape = RoundedCornerShape(radious.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor
        ), modifier = Modifier
            .padding(10.dp)
            .composed { modifier }
    ) {
        Text(text = title)
    }
}


@Composable
fun DisableButton(
    title: String = "Button",
    onClick: (() -> Unit),
    enabled: Boolean = true,
    radious: Int = 5,
    textColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(radious.dp),
        enabled = false,
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor
        ), modifier = Modifier.padding(10.dp)
    ) {
        Text(text = title)
    }
}

@Composable
fun ButtonWithColor() {
    Button(
        onClick = {
            //your onclick code
        },
        colors = ButtonDefaults.buttonColors(contentColor = Color.DarkGray)
    )

    {
        Text(text = "Button with gray background", color = Color.White)
    }
}

@Composable
fun ButtonWithTwoTextView() {
    Button(onClick = {
        //your onclick code here
    }) {
        Text(text = "Click ", color = Color.Magenta)
        Text(text = "Here", color = Color.Green)
    }
}

@Composable
fun ButtonWithIcon() {
    Button(onClick = {}) {
        Image(
            painterResource(id = R.mipmap.ic_launcher),
            contentDescription = "Cart button icon",
            modifier = Modifier.size(20.dp)
        )

        Text(text = "Add to cart", Modifier.padding(start = 10.dp))
    }
}


@Composable
fun ButtonWithRectangleShape() {
    Button(onClick = {}, shape = RectangleShape) {
        Text(text = "Rectangle shape")
    }
}

@Composable
fun ButtonWithRoundCornerShape() {
    Button(onClick = {}, shape = RoundedCornerShape(20.dp)) {
        Text(text = "Round corner shape")
    }
}


@Composable
fun ButtonWithCutCornerShape() {
    //CutCornerShape(percent: Int)- it will consider as percentage
    //CutCornerShape(size: Dp)- you can pass Dp also.
    //Here we use Int, so it will take percentage.
    Button(onClick = {}, shape = CutCornerShape(10)) {
        Text(text = "Cut corner shape")
    }
}

@Composable
fun ButtonWithBorder() {
    Button(
        onClick = {
            //your onclick code
        },
        border = BorderStroke(1.dp, Color.Red),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
    ) {
        Text(text = "Button with border", color = Color.DarkGray)
    }
}

@Composable
fun ButtonWithElevation() {
    Button(
        onClick = {
            //your onclick code here
        }, elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = "Button with elevation")
    }
}

@Composable
fun ButtonWithLeftIcon() {
    Button(
        onClick = { /* ... */ },
        // Uses ButtonDefaults.ContentPadding by default
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
    ) {
        // Inner content including an icon and a text label
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}

