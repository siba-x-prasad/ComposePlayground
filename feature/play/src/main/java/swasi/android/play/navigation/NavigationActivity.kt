package swasi.android.play.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import swasi.android.component.mycomponents.AppButton
import swasi.android.ui.theme.ComposePlaygroundTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationScreen()
        }
    }
}

@Composable
fun NavigationScreen() {
    ComposePlaygroundTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "auth") {
            composable("about") {
                // this will have access to other 2 routes
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        navController.navigate(
                            route = "auth"
                        ) {
                            popUpTo("auth") {
                                inclusive = true // it will be pup up from back stack
                            }
                        }
                    }
                    ) {
                        Text(text = "Auth", fontSize = 14.sp)
                    }

                    Button(onClick = {
                        navController.navigate(
                            route = "calendar"
                        ) {
                            popUpTo("calendar") {
                                inclusive = true // it will be pup up from back stack
                            }
                        }
                    }
                    ) {
                        Text(text = "Calendar", fontSize = 14.sp)
                    }
                }
            }
            navigation(
                startDestination = "Login",
                route = "auth"
            ) {
                composable("login") {
//                    val viewModel = it.sharedViewModel<AuthViewModel>(navController)

                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        AppButton(modifier = Modifier, onClick = {}, title = "LOGIN SCREEN")

                        AppButton(
                            onClick = {
                                navController.navigate(
                                    route = "calendar"
                                ) {
                                    popUpTo("auth") {
                                        inclusive = true // it will be pup up from back stack
                                    }
                                }
                            }, title = "Go to Calendar",
                            modifier = Modifier
                        )
                    }
                }
                composable("register") {
                    // val viewModel = it.sharedViewModel<AuthViewModel>(navController)
                }
                composable("forgotpassword") {
                    //  val viewModel = it.sharedViewModel<AuthViewModel>(navController)
                }
            }

            navigation(
                startDestination = "calendar_overview",
                route = "calendar"
            ) {
                composable("calendar_overview") {
                    // val viewModel = it.sharedViewModel<AuthViewModel>(navController)
                }
                composable("calendar_entry") {
                    // val viewModel = it.sharedViewModel<AuthViewModel>(navController)
                }
            }
        }
    }
}

@Preview
@Composable
fun NavigationScreenPreview() {
    NavigationScreen()
}

@Composable
fun <T> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}