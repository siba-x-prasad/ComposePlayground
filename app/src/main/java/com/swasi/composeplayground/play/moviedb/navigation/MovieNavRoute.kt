package com.swasi.composeplayground.play.moviedb.navigation

sealed class MovieNavRoute(val path: String) {

    object Splash : MovieNavRoute("splash")

    object SignIn : MovieNavRoute("signIn")

    object SignUp : MovieNavRoute("signUp")

    object OnBoarding : MovieNavRoute("onboarding")

    object Home : MovieNavRoute("home")

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


