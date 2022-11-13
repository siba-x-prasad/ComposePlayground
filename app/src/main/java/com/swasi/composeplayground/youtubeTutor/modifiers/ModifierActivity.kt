package com.swasi.composeplayground.youtubeTutor.modifiers

import android.content.Context
import android.os.Bundle
import android.widget.CalendarView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swasi.composeplayground.Greeting
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

class MyCalendar(context : Context) : CalendarView(context){

}

@Preview(showBackground = true, name = "PreviewColumn")
@Composable
fun DefaultPreview() {
    Column(
        Modifier
            .fillMaxSize()
//            .background(Color.Red)
            .border(5.dp, Color.Green, shape = RoundedCornerShape(2.dp))
            .padding(10.dp)
            .border(5.dp, Color.Blue, shape = CircleShape)
            .padding(10.dp)
            .border(5.dp, Color.Magenta, shape = RoundedCornerShape(2.dp))
            .padding(10.dp)
            .border(5.dp, Color.Black, shape = RoundedCornerShape(2.dp))
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
            ) {
        Text(text = "Siba", modifier = Modifier
            .border(5.dp, Color.Yellow)
            .padding(5.dp)
            .offset(20.dp, 20.dp)
            .border(10.dp, Color.Green, shape = RoundedCornerShape(6.dp))
        )

        Spacer(modifier = Modifier.height(50.dp).clickable {  })
        Text(text = "Prasad",  modifier = Modifier.clickable {
//            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        })
    }
}

/*
@Preview(showBackground = true, name = "PreviewRow")
@Composable
fun DefaultPreviewRow() {
    Row(
        Modifier.fillMaxSize()
            .background(Color.Red),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = "Siba")
        Text(text = "Prasad")
        Text(text = "Prasad")
    }
}*/
