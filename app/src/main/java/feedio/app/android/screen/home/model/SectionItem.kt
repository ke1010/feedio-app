package feedio.app.android.screen.home.model

data class SectionItem(
   val id: Int,
    val name: String,
    val description: String,
     val address: String,
     val ratings: Double,
    val imgUrl: String,
     val distanceKm: Double,
    val eta: String
) {
}