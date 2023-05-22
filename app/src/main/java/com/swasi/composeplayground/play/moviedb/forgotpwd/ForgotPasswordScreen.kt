package com.swasi.composeplayground.play.moviedb.forgotpwd

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.swasi.composeplayground.components.AppOutLinedTextFieldWithIcon
import kotlinx.coroutines.launch


/**
 * Created by Sibaprasad Mohanty on 12/03/2023.
 * siba.x.prasad@gmail.com
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ForgotPasswordBottomSheet() {

    val coroutineScope = rememberCoroutineScope()

    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Expanded,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    )

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetContent = {
            Column() {
                Button(
                    onClick = {
                        coroutineScope.launch { modalSheetState.hide() }
                    }
                ) {
                    Text(text = "Hide Sheet")
                }
            }
        }
    ) {
        Scaffold {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(it),
                contentAlignment = Alignment.BottomCenter,
            ) {

                AppOutLinedTextFieldWithIcon(
                    label = "Email Id",
                    icon = Icons.Default.Email,
                    onTextChanged = {

                    },
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier.align(Alignment.TopCenter)
                )

                Button(
                    onClick = {
                        coroutineScope.launch {
//                            if (modalSheetState.isVisible)
//                                modalSheetState.hide()
//                            else
//                                modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
                        }
                    },
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Text(text = "Submit")
                }
            }
        }
    }
}