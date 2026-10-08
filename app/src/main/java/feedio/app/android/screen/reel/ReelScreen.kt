package feedio.app.android.screen.reel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import feedio.app.android.screen.reel.component.ReelPageItem
import feedio.app.android.screen.reel.model.Reel

@Preview(showBackground = true)
@Composable
fun ReelScreen(
    reels: List<Reel> = sampleReels
) {
    val pagerState = rememberPagerState(
        pageCount = { reels.size }
    )

    // 2. Full-screen VerticalPager for snapping reel feeds
    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        val reel = reels[page]

        // 3. Render ReelPageItem per page
        ReelPageItem(
            name = reel.name,
            ratings = reel.ratings,
            likes = reel.likes,
            cmnts = reel.cmnts,
            caption = reel.caption,

        )
    }

}
private val sampleReels = listOf(
    Reel(1, "The Burger Joint", 4.5, "127", "32", "Double smash patties with extra cheese!"),
    Reel(2, "Pizza House", 4.8, "540", "98", "Freshly baked woodfire Margherita!"),
    Reel(3, "Taco Town", 4.2, "89", "12", "Crispy birria tacos with consommé dip!")
)