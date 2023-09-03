package com.swasi.composeplayground.appnav

sealed class AppNavRoute(val path: String) {

    object Splash : AppNavRoute("splash")

    object SignIn : AppNavRoute("signIn")
    object ForgotPassword : AppNavRoute("forgotPassword")

    object SignUp : AppNavRoute("signUp")

    object OnBoarding : AppNavRoute("onBoarding")

    object Home : AppNavRoute("home")
    object TvShow : AppNavRoute("tvShow")
    object AppScreen : AppNavRoute("Movie")

    object AppDetails : AppNavRoute("movieDetails") {
        val name = "name"
        val posterImage = "posterImage"
    }

    object FruitListScreen : AppNavRoute("FruitList")
    object FruitDetailsScreen : AppNavRoute("fruitDetails") {
        val fruitData = "fruitData"
    }

    object Profile : AppNavRoute("profile") {
        val id = "id"
        val showDetails = "showDetails"
    }

    object Search : AppNavRoute("search") {
        val query = "query"
    }

    // build navigation path (for screen navigation)
    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    // build and setup route format (in navigation graph)
    fun withArgsFormat(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/{$arg}")
            }
        }
    }
}


