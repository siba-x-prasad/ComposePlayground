package com.swasi.composeplayground.componentExamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class CheckboxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxDemo()
        }
    }
    @Composable
    fun CheckBoxDemo() {
        val checkedState = remember { mutableStateOf(true) }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it }
        )
    }

}