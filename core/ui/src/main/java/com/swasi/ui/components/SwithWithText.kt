package com.swasi.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun SwitchRow(name: String, change: Boolean, onCheckedChange: (Boolean) -> Unit) {

    Row(verticalAlignment = Alignment.CenterVertically) {

        Switch(
            checked = change,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Green,
                checkedTrackColor = Color.Yellow,
                uncheckedTrackColor = Color.Black
            )
        )

        Text(text = name)
    }
}