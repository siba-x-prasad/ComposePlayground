package com.swasi.composeplayground.play.moviedb.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swasi.composeplayground.components.AppButton
import com.swasi.composeplayground.components.AppOutLinedTextField
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
    ComposePlaygroundTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AppOutLinedTextField(label = "Name", onTextChanged = {
                    nameState = it
                })
                Spacer(modifier = Modifier.height(10.dp))
                AppOutLinedTextField(label = "Email", onTextChanged = {
                    emailState = it
                })
                Spacer(modifier = Modifier.height(10.dp))
                AppOutLinedTextField(label = "Mobile Number", onTextChanged = {
                    mobileState = it
                })
                Spacer(modifier = Modifier.height(10.dp))
                AppOutLinedTextField(
                    label = "Password", onTextChanged = {
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
}

@Preview
@Composable
fun SignupScreenPreview() {
    SignUpScreen(SignUpViewModel(), {}, {})
}