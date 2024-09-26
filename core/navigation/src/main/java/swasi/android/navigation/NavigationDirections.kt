package swasi.android.navigation

import androidx.navigation.NamedNavArgument

object NavigationDirections {

    val authentication = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "authentication"

    }

    val dashboard = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "dashboard"
    }
}