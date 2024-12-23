package com.swasi.compose.navigation

sealed class AppNavRoute(val path: String) {
    object Splash : AppNavRoute("splash")
    object SignIn : AppNavRoute("signIn")
    object ForgotPassword : AppNavRoute("forgotPassword")
    object SignUp : AppNavRoute("signUp")
    object OnBoarding : AppNavRoute("onBoarding")
    object Home : AppNavRoute("home")
    object TvShow : AppNavRoute("tvShow")
    object AppScreen : AppNavRoute("Movie")
    object PlayScreen : AppNavRoute("Play")
}


