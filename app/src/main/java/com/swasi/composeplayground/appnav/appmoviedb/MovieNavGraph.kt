package com.swasi.composeplayground.appnav.appmoviedb

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.swasi.composeplayground.navigation.screens.ProfileScreen
import com.swasi.composeplayground.navigation.screens.SearchScreen
import com.swasi.composeplayground.play.moviedb.details.MovieDetailsScreen
import com.swasi.composeplayground.play.moviedb.forgotpwd.ForgotPasswordBottomSheet
import com.swasi.composeplayground.play.moviedb.fruit.FruitDetailsScreen
import com.swasi.composeplayground.play.moviedb.fruit.FruitListScreen
import com.swasi.composeplayground.play.moviedb.home.MovieHomeScreen
import com.swasi.composeplayground.play.moviedb.movies.MovieScreen
import com.swasi.composeplayground.play.moviedb.onboarding.OnBoardingScreen
import com.swasi.composeplayground.play.moviedb.signin.SignInScreen
import com.swasi.composeplayground.play.moviedb.signup.SignUpScreen
import com.swasi.composeplayground.play.moviedb.splash.SplashScreen
import swasi.android.moviedb.tvshow.TvShowScreen

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

        addMovieScreen(navController, this)

        addMovieDetailsScreen(navController, this)

        addFruitListScreen(navController, this)

        addFruitDetailsScreen(navController, this)

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
            onNavigateToMovieScreen = {
                navController.navigate(MovieNavRoute.MovieScreen.path)
            },
            onNavigateToTvShow = {
                navController.navigate(MovieNavRoute.TvShow.path)
            },
            onNavigateToFruits = {
                navController.navigate(MovieNavRoute.FruitListScreen.path)
            },
            onNavigateToOnBoarding = {
                navController.navigate(MovieNavRoute.OnBoarding.path)
            },
            onNavigateToSignIn = {
                navController.navigate(MovieNavRoute.SignIn.path)
            },
            onNavigateToSIgnUp = {
                navController.navigate(MovieNavRoute.SignUp.path)
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

private fun addMovieScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = MovieNavRoute.MovieScreen.path) {
        MovieScreen(
            navigateToMovieDetails = { name, posterPath ->
                navController.navigate(
                    MovieNavRoute.MovieDetails.withArgs(
                        name,
                        posterPath
                    )
                )
            },
            navigateToDetails = { name, posterPath ->
                navController.navigate(
                    MovieNavRoute.MovieDetails.withArgs(
                        name,
                        posterPath
                    )
                )
            }
        )
    }
}

private fun addMovieDetailsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = MovieNavRoute.MovieDetails.withArgsFormat(
            MovieNavRoute.MovieDetails.name,
            MovieNavRoute.MovieDetails.posterImage
        ),
        arguments = listOf(
            navArgument(MovieNavRoute.MovieDetails.name) {
                type = NavType.StringType
            },
            navArgument(MovieNavRoute.MovieDetails.posterImage) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments

        MovieDetailsScreen(
            name = args?.getString(MovieNavRoute.MovieDetails.name),
            posterImage = args?.getString(MovieNavRoute.MovieDetails.posterImage),
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController) }
        )
    }
}

private fun addFruitListScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = MovieNavRoute.FruitListScreen.path) {
        FruitListScreen(
            navigateToFruitDetails = { fruitData ->
                navController.navigate(
                    MovieNavRoute.FruitDetailsScreen.withArgs(
                        fruitData
                    )
                )
            },
            navigateToHomeScreen = {
                navController.navigate(MovieNavRoute.Home.path)
            }
        )
    }
}

private fun addFruitDetailsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = MovieNavRoute.FruitDetailsScreen.withArgsFormat(
            MovieNavRoute.FruitDetailsScreen.fruitData
        ),
        arguments = listOf(
            navArgument(MovieNavRoute.FruitDetailsScreen.fruitData) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments

        FruitDetailsScreen(
            fruitDataInJson = args?.getString(MovieNavRoute.FruitDetailsScreen.fruitData),
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController) }
        )
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
