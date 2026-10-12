package feedio.app.android.navigation

import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
sealed interface DashboardRoute {
        @kotlinx.serialization.Serializable
        object Home : DashboardRoute
        @kotlinx.serialization.Serializable
        object Reel : DashboardRoute
        @Serializable
        object Account : DashboardRoute
    }
@Serializable
object MainDashboardRoute
