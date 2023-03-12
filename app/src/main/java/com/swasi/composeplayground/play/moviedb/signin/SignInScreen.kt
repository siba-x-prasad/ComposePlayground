package com.swasi.composeplayground.play.moviedb.signin

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.swasi.composeplayground.components.AppButton
import com.swasi.composeplayground.components.AppOutLinedTextFieldWithIcon
import com.swasi.composeplayground.components.AppOutlinedButton
import com.swasi.composeplayground.components.ProgressIndicator
import com.swasi.composeplayground.ui.theme.ComposePlaygroundTheme


/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Composable
fun SignInScreen(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    viewModel: SignInViewModel = hiltViewModel(),
    onNavigateToSignUp: () -> Unit,
    onNavigateToForgotPassword: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    // If `lifecycleOwner` changes, dispose and reset the effect
    DisposableEffect(lifecycleOwner) {
        // Create an observer that triggers our remembered callbacks
        // for sending analytics events
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {

            } else if (event == Lifecycle.Event.ON_STOP) {

            }
        }

        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)

        // When the effect leaves the Composition, remove the observer
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            onDispose { Log.i("SignInScreen", "Splash Screen  DISPOSED") }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Sign In",
                            color = Color.White
                        )
                    }
                })
        },
        content = {
            ComposePlaygroundTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    color = Color.White
                ) {
                    val focusManager = LocalFocusManager.current
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AppOutLinedTextFieldWithIcon(label = "Email Id",
                            icon = Icons.Default.Email,
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Next)
                            },
                            onTextChanged = {

                            })
                        Spacer(modifier = Modifier.height(10.dp))
                        AppOutLinedTextFieldWithIcon(label = "Password",
                            icon = Icons.Default.Settings,
                            onDone = {
                                focusManager.moveFocus(FocusDirection.Down)
                            },
                            visualTransformation = PasswordVisualTransformation(),
                            onTextChanged = {

                            })
                        Spacer(modifier = Modifier.height(10.dp))
                        AppButton(text = "SignIn", onClick = {
//                    viewModel.signIn()
                            onNavigateToHome()
                        })
                        Spacer(modifier = Modifier.height(10.dp))
                        if (viewModel.isLoading.value) {
                            ProgressIndicator()
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            AppOutlinedButton(text = "Forgot Password", onClick = {
                                onNavigateToForgotPassword()
                            })
                            AppOutlinedButton(text = "SignUp", onClick = {
                                onNavigateToSignUp()
                            })
                        }
                    }
                }
            }
        })
}

@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen(LocalLifecycleOwner.current, SignInViewModel(), {}, {}, {})
}