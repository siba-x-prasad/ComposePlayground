package com.swasi.composeplayground.utility

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner

@Composable
fun MyScreen() {
    var viewState by remember { mutableStateOf(0) }
    when (viewState) {
        1 -> BackHandler(enabled = true) {
            viewState = 0
        }
        2 -> BackHandler(enabled = true) {
            viewState = 1
        }
        3 -> BackHandler(enabled = true) {
            viewState = 3
        }
    }
    Column {
        when (viewState) {
            0 -> {
                Button(onClick = { viewState = 1 }) { Text(text = "Goto 1") }
            }
            1 -> {
                Button(onClick = { viewState = 2 }) { Text(text = "Goto 2") }
            }
            2 -> {
                Button(onClick = { viewState = 3 }) { Text(text = "Goto 3") }
            }
            3 -> {
                Button(onClick = { viewState = 0 }) { Text(text = "Goto 0") }
            }
        }
    }
}


@Composable
fun BackHandler(enabled: Boolean = true, onBack: () -> Unit) {
    // Safely update the current `onBack` lambda when a new one is provided
    val currentOnBack by rememberUpdatedState(onBack)
    // Remember in Composition a back callback that calls the `onBack` lambda
    val backCallback = remember {
        object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() {
                currentOnBack()
            }
        }
    }
    // On every successful composition, update the callback with the `enabled` value
    SideEffect {
        backCallback.isEnabled = enabled
    }
    val backDispatcher = checkNotNull(LocalOnBackPressedDispatcherOwner.current) {
        "No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner"
    }.onBackPressedDispatcher
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner, backDispatcher) {
        // Add callback to the backDispatcher
        backDispatcher.addCallback(lifecycleOwner, backCallback)
        // When the effect leaves the Composition, remove the callback
        onDispose {
            backCallback.remove()
        }
    }
}