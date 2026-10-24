package feedio.app.android.screen.home.model

data class HomeFeedResponse(
    val success: Boolean,
    val message : String,
    val headerDto : HeaderDto,
    val sectionDto: List<SectionDto>,
    val paginationDto : PaginationDto
) {
}