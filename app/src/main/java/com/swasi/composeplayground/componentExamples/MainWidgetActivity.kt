package com.swasi.composeplayground.componentExamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainWidgetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxExample()
        }
    }

    @Composable
    fun BoxExample() {
        Box(Modifier.fillMaxSize()) {
            Text("This is first text", modifier = Modifier.align(Alignment.TopCenter))
            Box(
                Modifier.align(Alignment.TopCenter).fillMaxHeight().width(
                    1.dp
                ).background( Color.Blue)
            )

            Box(
                Modifier.align(Alignment.Center).fillMaxWidth().height(
                    1.dp
                ).background( Color.Blue)
            )

            Text("This is second text", modifier = Modifier.align(Alignment.Center))
            FloatingActionButton(
                modifier = Modifier.align(Alignment.BottomEnd).padding(12.dp),
                onClick = {
                    Toast.makeText(this@MainWidgetActivity,"Bottom End clicked",Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("+")
            }
            FloatingActionButton(
                modifier = Modifier.align(Alignment.TopEnd).padding(12.dp),
                onClick = {
                    Toast.makeText(this@MainWidgetActivity,"TOP End clicked",Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("+")
            }

            FloatingActionButton(
                modifier = Modifier.align(Alignment.TopStart).padding(12.dp),
                onClick = {
                    Toast.makeText(this@MainWidgetActivity,"Top Start clicked",Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("+")
            }

            FloatingActionButton(
                modifier = Modifier.align(Alignment.BottomStart).padding(12.dp),
                onClick = {
                    Toast.makeText(this@MainWidgetActivity,"Bottom Start clicked",Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("+")
            }
        }
    }
}