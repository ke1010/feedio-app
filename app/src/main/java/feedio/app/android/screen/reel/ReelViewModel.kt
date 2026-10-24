package feedio.app.android.screen.reel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import feedio.app.android.UiState
import feedio.app.android.network.NetworkResult
import feedio.app.android.screen.reel.model.ReelResponse
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ReelViewModel @Inject constructor(
    private val reelRepository: ReelRepository
) : ViewModel(){

     var uiState by mutableStateOf<UiState<ReelResponse>>(UiState.Loading)

    init {
        fetchReel()
    }

    fun fetchReel() {
        viewModelScope.launch {
            when (val result = reelRepository.fetchReel(1)) {
                is NetworkResult.Success -> {
                    Log.d("ReelResponse",result.data.toString() )
                   uiState = UiState.Success(result.data)
                }

                is NetworkResult.Loading -> {
                  uiState = UiState.Loading
                }

                is NetworkResult.Error -> {
                uiState = UiState.Error(result.message)
                }
            }
        }
    }
}