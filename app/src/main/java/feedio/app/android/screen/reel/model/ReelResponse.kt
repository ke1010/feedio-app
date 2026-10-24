package feedio.app.android.screen.reel.model

data class ReelResponse(
    val success: Boolean,
    val message : String,
    val reelItemDtos: ArrayList<ReelItem>,
    val last : Boolean
) {
}