package swasi.android.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

object DashboardNavigation {

    private val KEY_USER_ID = "userId"
    val route = "dashboard/{$KEY_USER_ID}"
    val arguments = listOf(
        navArgument(KEY_USER_ID) { type = NavType.StringType }
    )

    fun dashboard(
        userId: String? = null
    ) = object : NavigationCommand {

        override val arguments = listOf(
            navArgument(KEY_USER_ID) { type = NavType.StringType }
        )

        override val destination = "dashboard/$userId"
    }

}