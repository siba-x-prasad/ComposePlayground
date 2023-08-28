package com.swasi.composeplayground.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import swasi.android.account.forgotpwd.ForgotPasswordBottomSheet
import swasi.android.account.onboarding.OnBoardingScreen
import swasi.android.account.signin.SignInScreen
import swasi.android.account.signup.SignUpScreen
import swasi.android.account.splash.SplashScreen

@Composable
fun GlobalNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = GlobalNavRoute.Splash.path
    ) {
        addSplashScreen(navController, this)

        addOnBoardingScreen(navController, this)

        addSignInScreen(navController, this)

        addForgotPasswordScreen(navController, this)

        addSignUpScreen(navController, this)

    }
}

private fun addSplashScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = GlobalNavRoute.Splash.path) {
        SplashScreen(
            onNavigateToOnBoarding = {
                navController.navigate(GlobalNavRoute.OnBoarding.path)
            }
        )
    }
}

private fun addOnBoardingScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = GlobalNavRoute.OnBoarding.path) {
        OnBoardingScreen(
            onNavigateToSignIn = {
                navController.navigate(GlobalNavRoute.SignIn.path) {
                    popUpTo(GlobalNavRoute.OnBoarding.path)
                }
            },
            onNavigateToSignUp = {
                navController.navigate(GlobalNavRoute.SignUp.path)
            }
        )
    }
}

private fun addSignInScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = GlobalNavRoute.SignIn.path) {
        SignInScreen(
            onNavigateToHome = {
                navController.navigate(GlobalNavRoute.Home.path)
            },
            onNavigateToSignUp = {
                navController.navigate(GlobalNavRoute.SignUp.path)
            },
            onNavigateToForgotPassword = {
                navController.navigate(GlobalNavRoute.ForgotPassword.path)
            }
        )
    }
}

private fun addSignUpScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = GlobalNavRoute.SignUp.path) {
        SignUpScreen(
            onNavigateToHome = {
                navController.navigate(GlobalNavRoute.Home.path)
            },
            onNavigateToSIgnIn = {
                navController.navigate(GlobalNavRoute.SignIn.path)
            }
        )
    }
}

private fun addForgotPasswordScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = GlobalNavRoute.ForgotPassword.path) {
        ForgotPasswordBottomSheet()
    }
}


private fun popUpToLogin(navController: NavHostController) {
    navController.popBackStack(GlobalNavRoute.SignIn.path, inclusive = false)
}

private fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = GlobalNavRoute.Profile.withArgsFormat(
            GlobalNavRoute.Profile.id,
            GlobalNavRoute.Profile.showDetails
        ),
        arguments = listOf(
            navArgument(GlobalNavRoute.Profile.id) {
                type = NavType.IntType
            },
            navArgument(GlobalNavRoute.Profile.showDetails) {
                type = NavType.BoolType
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments


    }
}

private fun addSearchScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = GlobalNavRoute.Search.withArgsFormat(GlobalNavRoute.Search.query),
        arguments = listOf(
            navArgument(GlobalNavRoute.Search.query) {
                type = NavType.StringType
                nullable = true
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments


    }
}
