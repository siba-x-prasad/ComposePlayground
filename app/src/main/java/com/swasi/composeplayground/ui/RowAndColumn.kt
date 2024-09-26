package com.swasi.composeplayground.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Created by Sibaprasad Mohanty on 25/02/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun RowExample1(totalItem: Int = 5){
    Row(modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceAround
        ) {
    for (i in 0..totalItem)    {
            Text(text = "Item $i",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(1.dp)
                    .background(Color.Black)
                    .padding(5.dp))
        }
    }
}

@Composable
fun ColumnExample1(totalItem: Int = 5){
    Column {
        for (i in 0..totalItem)    {
            Text(text = "Item 1", modifier = Modifier.background(Color.Red), fontSize = 16.sp )
        }
    }
}


@Preview
@Composable
fun RowPreview(){
    RowExample1()
}

@Preview
@Composable
fun ColumnPreview(){
    ColumnExample1()
}