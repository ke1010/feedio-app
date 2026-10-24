package feedio.app.android.navigation

import kotlinx.serialization.Serializable

sealed interface NavRoute{
@Serializable
    data object AuthGraph : NavRoute
    @Serializable
    object Auth : NavRoute

    @Serializable
    data object VerifyOtp : NavRoute

    @Serializable
    object Home : NavRoute

    @Serializable
    data class Menu(val restaurantId: String) : NavRoute



}