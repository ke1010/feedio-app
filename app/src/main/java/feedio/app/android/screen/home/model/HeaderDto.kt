package feedio.app.android.screen.home.model

data class HeaderDto(
    val location: String,
    val greetingMessage: String,
    val hasUnreadNotifications: Boolean
) {
}