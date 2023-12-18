package swasi.android.ui.components


import android.view.MotionEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.OutlinedButton
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
import swasi.android.ui.R
import swasi.android.ui.theme.Colors

@ExperimentalComposeUiApi
@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String = "Hello",
    buttonColor: Color = Colors.teal700,
    textColor: Color = Color.White,
    enabled: Boolean = true,
    onClick: (() -> Unit),
    radios: Int = 8
) {

    val color = remember { mutableStateOf(buttonColor) }

    Button(
        modifier = Modifier
            .padding(8.dp)
//            .pointerInteropFilter {
//                when (it.action) {
//                    MotionEvent.ACTION_DOWN -> {
//                        color.value = Colors.teal700
//                    }
//
//                    MotionEvent.ACTION_UP -> {
//                        color.value = Colors.teal200
//                    }
//                }
//                true
//            }
            .then(modifier),
        onClick = onClick,
        shape = RoundedCornerShape(radios.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = color.value,
            contentColor = textColor
        )
    ) {
        Text(color = textColor, text = text)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun AppButtonEnablePreview() {
    AppButton(onClick = {

    })
}

@ExperimentalComposeUiApi
@Composable
fun AppButtonDisable(
    modifier: Modifier = Modifier,
    title: String = "Hello",
    buttonColor: Color = Color.Gray,
    textColor: Color = Color.White,
    onClick: (() -> Unit),
    radios: Int = 8,
    enable: Boolean = true
) {

    val color = remember { mutableStateOf(buttonColor) }

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(radios.dp),
        enabled = enable,
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
            .then(modifier)
    ) {
        Text(color = textColor, text = title)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun AppButtonDisablePreview() {
    AppButtonDisable(
        title = "Cancel",
        onClick = {}
    )
}

@ExperimentalComposeUiApi
@Composable
fun AppButtonWithIcon(
    modifier: Modifier = Modifier,
    title: String = "Hello",
    buttonColor: Color = Colors.teal700,
    textColor: Color = Color.White,
    enabled: Boolean = true,
    onClick: (() -> Unit),
    radios: Int = 8,
    iconDrawable: Int,
    iconContentDesc: String = "content description"
) {

    val color = remember { mutableStateOf(buttonColor) }

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(radios.dp),
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
            .then(modifier)
    ) {
        Image(
            painterResource(id = iconDrawable),
            contentDescription = iconContentDesc,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(color = textColor, text = title)
    }
}

@Composable
fun AppOutlinedButton(
    text: String = "Hello",
    textColor: Color = Color.Black,
    modifier: Modifier = Modifier.padding(0.dp),
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier.composed { modifier },
        onClick = onClick
    ) {
        Text(
            text = text, Modifier.padding(start = 10.dp),
            color = textColor
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun AppButtonIconPreview() {
    AppButtonWithIcon(
        title = "AppButton with Icon",
        onClick = {},
        iconDrawable = R.drawable.ic_rabit
    )
}

@Composable
fun DisableButton(
    title: String = "Button",
    onClick: (() -> Unit),
    radios: Int = 5,
    textColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(radios.dp),
        enabled = false,
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor
        ), modifier = Modifier.padding(10.dp)
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(title)
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
            painterResource(id = R.drawable.ic_rabit),
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
        border = BorderStroke(1.dp, Colors.teal700),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Colors.teal700)
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


