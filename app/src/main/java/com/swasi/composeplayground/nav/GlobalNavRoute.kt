package com.swasi.composeplayground.nav

sealed class GlobalNavRoute(val path: String) {

    object Splash : GlobalNavRoute("splash")

    object SignIn : GlobalNavRoute("signIn")
    object ForgotPassword : GlobalNavRoute("forgotPassword")

    object SignUp : GlobalNavRoute("signUp")

    object OnBoarding : GlobalNavRoute("onBoarding")

    object Home : GlobalNavRoute("home")
    object TvShow : GlobalNavRoute("tvShow")
    object GlobalScreen : GlobalNavRoute("Movie")

    object GlobalDetails : GlobalNavRoute("movieDetails") {
        val name = "name"
        val posterImage = "posterImage"
    }

    object FruitListScreen : GlobalNavRoute("FruitList")
    object FruitDetailsScreen : GlobalNavRoute("fruitDetails") {
        val fruitData = "fruitData"
    }

    object Profile : GlobalNavRoute("profile") {
        val id = "id"
        val showDetails = "showDetails"
    }

    object Search : GlobalNavRoute("search") {
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


