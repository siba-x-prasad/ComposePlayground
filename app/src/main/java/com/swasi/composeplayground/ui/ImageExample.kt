package com.swasi.composeplayground.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swasi.composeplayground.R


/**
 * Created by Sibaprasad Mohanty on 25/02/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun SimpleImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_cart),
        contentDescription = "Andy Rubin",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CircleImageView() {
    Image(
        painter = painterResource(R.drawable.andy_rubin),
        contentDescription = "Circle Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape) // clip to the circle shape
            .border(5.dp, Color.Gray, CircleShape)//optional
    )
}

@Composable
fun RoundCornerImageView() {
    Image(
        painter = painterResource(R.drawable.andy_rubin),
        contentDescription = "Round corner image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(RoundedCornerShape(10))
            .border(5.dp, Color.Gray, RoundedCornerShape(10))
    )
}

@Composable
fun ImageWithBackgroundColor() {
    Image(
        painter = painterResource(id = R.drawable.ic_cart),
        contentDescription = "",
        modifier = Modifier
            .size( 200.dp)
            .background(Color.DarkGray)
            .padding(20.dp)
    )
}

@Composable
fun ImageWithTint() {
    Image(
        painter = painterResource(id = R.drawable.ic_cart),
        contentDescription = "",
        colorFilter = ColorFilter.tint(Color.Red),
        modifier = Modifier
            .size( 200.dp)
    )
}

@Composable
fun InsideFit() {
    Image(
        painter = painterResource(id = R.drawable.andy_rubin),
        contentDescription = "",
        modifier = Modifier
            .size(150.dp)
            .background(Color.LightGray),
        contentScale = ContentScale.Inside
    )
}

@Preview
@Composable
fun SimpleImagePreview(){
    SimpleImage()
}

@Preview
@Composable
fun CircleImageViewPreview(){
    CircleImageView()
}

@Preview
@Composable
fun RoundCornerImageViewPreview(){
    RoundCornerImageView()
}

@Preview
@Composable
fun ImageWithBackgroundColorPreview(){
    ImageWithBackgroundColor()
}

@Preview
@Composable
fun ImageWithTintPreview(){
    ImageWithTint()
}

@Preview
@Composable
fun InsideFitPreview(){
    InsideFit()
}

