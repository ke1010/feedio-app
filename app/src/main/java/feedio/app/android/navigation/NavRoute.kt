package feedio.app.android.navigation

import kotlinx.serialization.Serializable

sealed interface NavRoute{

    @Serializable
    object Auth : NavRoute

    @Serializable
    data class VerifyOtp(val phoneNumber: String) : NavRoute

    @Serializable
    object Home : NavRoute

    @Serializable
    data class Menu(val restaurantId: String) : NavRoute



}