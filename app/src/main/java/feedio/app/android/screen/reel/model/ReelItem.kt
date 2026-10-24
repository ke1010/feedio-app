package feedio.app.android.screen.reel.model

data class ReelItem(
    val videoUrl : String,
    val likes : Int,
    val comments: Int,
    val caption: String,
    val liked : Boolean

) {
}