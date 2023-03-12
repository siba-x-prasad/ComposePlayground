package com.swasi.composeplayground.play.moviedb.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    onNavigateToSIgnIn: () -> Unit,
    onNavigateToHome: () -> Unit
) {

    var nameState = ""
    var emailState = ""
    var mobileState = ""
    var passwordState = ""
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Sign Up",
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
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AppOutLinedTextFieldWithIcon(label = "Name",
                            icon = Icons.Default.Person, onTextChanged = {
                                nameState = it
                            })
                        Spacer(modifier = Modifier.height(10.dp))
                        AppOutLinedTextFieldWithIcon(label = "Email",
                            icon = Icons.Default.Email, onTextChanged = {
                                emailState = it
                            })
                        Spacer(modifier = Modifier.height(10.dp))
                        AppOutLinedTextFieldWithIcon(label = "Mobile Number",
                            icon = Icons.Default.Phone,
                            onTextChanged = {
                                mobileState = it
                            })
                        Spacer(modifier = Modifier.height(10.dp))
                        AppOutLinedTextFieldWithIcon(
                            label = "Password",
                            icon = Icons.Default.Settings,
                            onTextChanged = {
                                passwordState = it
                            },
                            visualTransformation = PasswordVisualTransformation()
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        AppButton(text = "Signup", onClick = {
                            viewModel.signUp()
                            onNavigateToHome()
                        })
                        if (viewModel.isLoading.value) {
                            ProgressIndicator()
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        AppOutlinedButton(text = "Sign In", onClick = {
                            onNavigateToSIgnIn()
                        })
                    }
                }
            }
        })
}

@Preview
@Composable
fun SignupScreenPreview() {
    SignUpScreen(SignUpViewModel(), {}, {})
}