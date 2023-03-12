package com.swasi.composeplayground.play.moviedb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.swasi.composeplayground.navigation.screens.ProfileScreen
import com.swasi.composeplayground.navigation.screens.SearchScreen
import com.swasi.composeplayground.play.moviedb.forgotpwd.ForgotPasswordBottomSheet
import com.swasi.composeplayground.play.moviedb.home.MovieHomeScreen
import com.swasi.composeplayground.play.moviedb.onboarding.OnBoardingScreen
import com.swasi.composeplayground.play.moviedb.signin.SignInScreen
import com.swasi.composeplayground.play.moviedb.signup.SignUpScreen
import com.swasi.composeplayground.play.moviedb.splash.SplashScreen
import com.swasi.composeplayground.play.moviedb.tvshow.TvShowScreen

@Composable
fun MovieNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = MovieNavRoute.Splash.path
    ) {
        addSplashScreen(navController, this)

        addOnBoardingScreen(navController, this)

        addSignInScreen(navController, this)

        addForgotPasswordScreen(navController, this)

        addSignUpScreen(navController, this)

        addHomeScreen(navController, this)

        addTvShowScreen(navController, this)

        addProfileScreen(navController, this)

        addSearchScreen(navController, this)
    }
}

private fun addSplashScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = MovieNavRoute.Splash.path) {
        SplashScreen(
            onNavigateToOnBoarding = {
                navController.navigate(MovieNavRoute.OnBoarding.path)
            }
        )
    }
}

private fun addOnBoardingScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = MovieNavRoute.OnBoarding.path) {
        OnBoardingScreen(
            onNavigateToSignIn = {
                navController.navigate(MovieNavRoute.SignIn.path) {
                    popUpTo(MovieNavRoute.OnBoarding.path)
                }
            },
            onNavigateToSignUp = {
                navController.navigate(MovieNavRoute.SignUp.path)
            }
        )
    }
}

private fun addSignInScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = MovieNavRoute.SignIn.path) {
        SignInScreen(
            onNavigateToHome = {
                navController.navigate(MovieNavRoute.Home.path)
            },
            onNavigateToSignUp = {
                navController.navigate(MovieNavRoute.SignUp.path)
            },
            onNavigateToForgotPassword = {
                navController.navigate(MovieNavRoute.ForgotPassword.path)
            }
        )
    }
}

private fun addSignUpScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = MovieNavRoute.SignUp.path) {
        SignUpScreen(
            onNavigateToHome = {
                navController.navigate(MovieNavRoute.Home.path)
            },
            onNavigateToSIgnIn = {
                navController.navigate(MovieNavRoute.SignIn.path)
            }
        )
    }
}

private fun addForgotPasswordScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = MovieNavRoute.ForgotPassword.path) {
        ForgotPasswordBottomSheet()
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = MovieNavRoute.Home.path) {

        MovieHomeScreen(
            onNavigateToProfile = {

            },
            onNavigateToTvShow = {
                navController.navigate(MovieNavRoute.TvShow.path)
            }
        )
    }
}

private fun addTvShowScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = MovieNavRoute.TvShow.path) {
        TvShowScreen()
    }
}

private fun popUpToLogin(navController: NavHostController) {
    navController.popBackStack(MovieNavRoute.SignIn.path, inclusive = false)
}

private fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = MovieNavRoute.Profile.withArgsFormat(
            MovieNavRoute.Profile.id,
            MovieNavRoute.Profile.showDetails
        ),
        arguments = listOf(
            navArgument(MovieNavRoute.Profile.id) {
                type = NavType.IntType
            },
            navArgument(MovieNavRoute.Profile.showDetails) {
                type = NavType.BoolType
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments

        ProfileScreen(
            id = args?.getInt(MovieNavRoute.Profile.id)!!,
            showDetails = args.getBoolean(MovieNavRoute.Profile.showDetails),
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController) }
        )
    }
}

private fun addSearchScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = MovieNavRoute.Search.withArgsFormat(MovieNavRoute.Search.query),
        arguments = listOf(
            navArgument(MovieNavRoute.Search.query) {
                type = NavType.StringType
                nullable = true
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments

        SearchScreen(
            query = args?.getString(MovieNavRoute.Search.query),
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController) }
        )
    }
}
