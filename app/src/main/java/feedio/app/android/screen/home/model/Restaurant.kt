package feedio.app.android.screen.home.model

data class Restaurant(
    val id : Int,
    val name : String,
    val address: String,
    val distanceKm : Double,
    val imgUrl : String,
    val esTime: String,
    val ratings: Double
)