package com.swasi.composeplayground.appnav

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
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = AppNavRoute.Splash.path
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
    navGraphBuilder.composable(route = AppNavRoute.Splash.path) {
        SplashScreen(
            onNavigateToOnBoarding = {
                navController.navigate(AppNavRoute.OnBoarding.path)
            }
        )
    }
}

private fun addOnBoardingScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = AppNavRoute.OnBoarding.path) {
        OnBoardingScreen(
            onNavigateToSignIn = {
                navController.navigate(AppNavRoute.SignIn.path) {
                    popUpTo(AppNavRoute.OnBoarding.path)
                }
            },
            onNavigateToSignUp = {
                navController.navigate(AppNavRoute.SignUp.path)
            }
        )
    }
}

private fun addSignInScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = AppNavRoute.SignIn.path) {
        SignInScreen(
            onNavigateToHome = {
                navController.navigate(AppNavRoute.Home.path)
            },
            onNavigateToSignUp = {
                navController.navigate(AppNavRoute.SignUp.path)
            },
            onNavigateToForgotPassword = {
                navController.navigate(AppNavRoute.ForgotPassword.path)
            }
        )
    }
}

private fun addSignUpScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = AppNavRoute.SignUp.path) {
        SignUpScreen(
            onNavigateToHome = {
                navController.navigate(AppNavRoute.Home.path)
            },
            onNavigateToSIgnIn = {
                navController.navigate(AppNavRoute.SignIn.path)
            }
        )
    }
}

private fun addForgotPasswordScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = AppNavRoute.ForgotPassword.path) {
        ForgotPasswordBottomSheet()
    }
}


private fun popUpToLogin(navController: NavHostController) {
    navController.popBackStack(AppNavRoute.SignIn.path, inclusive = false)
}

private fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = AppNavRoute.Profile.withArgsFormat(
            AppNavRoute.Profile.id,
            AppNavRoute.Profile.showDetails
        ),
        arguments = listOf(
            navArgument(AppNavRoute.Profile.id) {
                type = NavType.IntType
            },
            navArgument(AppNavRoute.Profile.showDetails) {
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
        route = AppNavRoute.Search.withArgsFormat(AppNavRoute.Search.query),
        arguments = listOf(
            navArgument(AppNavRoute.Search.query) {
                type = NavType.StringType
                nullable = true
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments


    }
}
