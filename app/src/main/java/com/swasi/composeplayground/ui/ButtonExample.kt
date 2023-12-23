package com.swasi.composeplayground.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swasi.composeplayground.R

/**
 * Created by Sibaprasad Mohanty on 25/02/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun ButtonExample(buttonName : String = "Login", modifier: Modifier = Modifier){
    Button(onClick = {
    }, modifier = modifier.fillMaxWidth()) {
        Text(text = buttonName)
    }
}

@Composable
fun ButtonWithColor(){
    Button(onClick = {
        //your onclick code
    },
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray))

    {
        Text(text = "Button with gray background",color = Color.White)
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
            painterResource(id = R.drawable.ic_cart),
            contentDescription ="Cart button icon",
            modifier = Modifier.size(20.dp))

        Text(text = "Add to cart",Modifier.padding(start = 10.dp))
    }
}

@Composable
fun ButtonWithRectangleShape() {
    Button(onClick = { }, shape = RectangleShape) {
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
            // your onclick code
        },
        border = BorderStroke(1.dp, Color.Red),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Red,
            containerColor = Color.Black)
    ) {
        Text(text = "Button with border", color = Color.White)
    }
}

@Composable
fun ButtonWithElevation() {
    Button(onClick = {
        //your onclick code here
    },elevation =  ButtonDefaults.buttonElevation(
        defaultElevation = 10.dp,
        pressedElevation = 15.dp,
        disabledElevation = 0.dp
    )) {
        Text(text = "Button with elevation")
    }
}

@Preview
@Composable
fun ButtonPreview1(){
    ButtonExample()
}


@Preview
@Composable
fun ButtonWithColorPreview(){
    ButtonWithColor()
}

@Preview
@Composable
fun ButtonWithTwoTextViewPreview() {
    ButtonWithTwoTextView()
}

@Preview
@Composable
fun ButtonWithIconPreview() {
    ButtonWithIcon()
}

@Preview
@Composable
fun ButtonWithRectangleShapePreview() {
    ButtonWithRectangleShape()
}

@Preview
@Composable
fun ButtonWithRoundCornerShapePreview() {
    ButtonWithRoundCornerShape()
}

@Preview
@Composable
fun ButtonWithCutCornerShapePreview() {
    ButtonWithCutCornerShape()
}

@Preview
@Composable
fun ButtonWithBorderPreview() {
    ButtonWithBorder()
}

@Preview
@Composable
fun ButtonWithElevationPreview() {
    ButtonWithElevation()
}