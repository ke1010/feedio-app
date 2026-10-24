package feedio.app.android.screen.home.model

data class SectionDto(
    val id : Int,
    val title: String,
    val items : List<SectionItem>
) {
}