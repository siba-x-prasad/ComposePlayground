package com.swasi.composeplayground.componentExamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

class FabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FloatingActionButtonSample()
        }
    }
    @Composable
    fun FloatingActionButtonSample() {
        FloatingActionButton(onClick = {
            Toast.makeText(this,"FAB clicked", Toast.LENGTH_SHORT).show()
        }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
        }
    }
}