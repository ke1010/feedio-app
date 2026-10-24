package feedio.app.android.screen.reel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import feedio.app.android.UiState
import feedio.app.android.screen.reel.component.ReelPageItem
import feedio.app.android.screen.reel.model.Reel
import feedio.app.android.ui.theme.PlusJakartaSans
import feedio.app.android.ui.theme.Teal

@Composable
fun ReelScreen(

    modifier: Modifier = Modifier,
    reelViewModel: ReelViewModel = hiltViewModel()
) {
    val uiState = reelViewModel.uiState

    Box(modifier = modifier.fillMaxSize()) {
        when (val state = uiState) {
            is UiState.Loading, is UiState.Idle -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Teal)
                }
            }
            is UiState.Success -> {
                val reels = state.data.reelItemDtos

                val pagerState = rememberPagerState(
                    pageCount = {reels.size}
                )

                VerticalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxSize()
                ) { page ->
                    val reel = reels[page]

                    ReelPageItem(
                        videoUrl = reel.videoUrl,
                        likes = reel.likes,
                        cmnts = reel.comments,
                        caption = reel.caption
                    )
                }
            }
            is UiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = state.message,
                        color = Color.Red,
                        fontFamily = PlusJakartaSans,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }
}
