package com.swasi.composeplayground.componentExamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

class SnackBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackbarSample()
        }
    }

    @Composable
    fun SnackbarSample(){
//        val scaffoldState = rememberScaffoldState()
//        val scope = rememberCoroutineScope()
//        Scaffold(
//            scaffoldState = scaffoldState,
//            floatingActionButton = {
//                var clickCount by remember { mutableStateOf(0) }
//                ExtendedFloatingActionButton(
//                    text = { Text("Show snackbar") },
//                    onClick = {
//                        // show snackbar as a suspend function
//                        scope.launch {
//                            scaffoldState.snackbarHostState.showSnackbar("Snackbar # ${++clickCount}")
//                        }
//                    }
//                )
//            },
//            content = { innerPadding ->
//                Text(
//                    text = "Body content",
//                    modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
//                )
//            }
//        )
    }
}