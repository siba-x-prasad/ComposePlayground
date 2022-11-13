package com.swasi.composeplayground.play

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme

class ComposePlayGroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp() {
                MyScreen()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposePlaygroundTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun MyScreen(list: List<String> = listOf("Hello", "Android")) {
    var counterState by remember {
        mutableStateOf(0)
    }
    Column {
        /* for (item in list) {
             Greeting(item)
             Spacer(modifier = Modifier.padding(10.dp))
         }*/
        NamesList(
            list = list, modifier = Modifier
                .padding(10.dp)
                .weight(1f)
        )
        Greeting("Android")
        Counter(count = counterState,
            updateCounter = { newCounter ->
                counterState = newCounter
            }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        if (counterState > 5) {
            Text(text = "Stop Count")
        } else if (counterState > 10) {
            Text(text = "I Love to Count")
        }
    }
}

@Composable
fun Greeting(name: String) {

    var isSelected by remember {
        mutableStateOf(false)
    }

    val backgroundColor = if (isSelected) Color.Red else Color.Transparent

    val targetColor by animateColorAsState(
        targetValue = backgroundColor,
        animationSpec = tween(4000)
    )

    Surface(color = targetColor, modifier = Modifier.padding(0.dp)) {
        Text(
            text = "Hello $name!",
            modifier = Modifier
                .background(backgroundColor)
                .clickable { isSelected = !isSelected }
                .padding(0.dp)
        )

    }
}

@Composable
fun Counter(count: Int, updateCounter: (Int) -> Unit) {
    Button(onClick = { updateCounter(count + 1) }) {
        Text(text = "I Have been clicked $count times")
    }
}

@Composable
fun NamesList(list: List<String>, modifier: Modifier) {
    LazyColumn(modifier) {
        items(list) {
            Greeting(name = it)
            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreen()
    }
}