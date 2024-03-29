package com.swasi.composeplayground.appnav.appmoviedb

sealed class MovieNavRoute(val path: String) {

    object Splash : MovieNavRoute("splash")

    object SignIn : MovieNavRoute("signIn")
    object ForgotPassword : MovieNavRoute("forgotPassword")

    object SignUp : MovieNavRoute("signUp")

    object OnBoarding : MovieNavRoute("onBoarding")

    object Home : MovieNavRoute("home")
    object TvShow : MovieNavRoute("tvShow")
    object MovieScreen : MovieNavRoute("Movie")

    object MovieDetails : MovieNavRoute("movieDetails") {
        val name = "name"
        val posterImage = "posterImage"
    }

    object FruitListScreen : MovieNavRoute("FruitList")
    object FruitDetailsScreen : MovieNavRoute("fruitDetails") {
        val fruitData = "fruitData"
    }

    object Profile : MovieNavRoute("profile") {
        val id = "id"
        val showDetails = "showDetails"
    }

    object Search : MovieNavRoute("search") {
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


