package feedio.app.android.screen.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import feedio.app.android.UiState
import feedio.app.android.network.NetworkResult
import feedio.app.android.screen.home.model.HomeFeedResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private  val homeRepository: HomeRepository) : ViewModel(){

    var uiState by mutableStateOf<UiState<HomeFeedResponse>>(UiState.Loading)
        private set

    init {
        fetchHomeData()
    }

    fun fetchHomeData(){
        viewModelScope.launch {
            val lat = 28.8486
            val lng = 78.2383
            when(val result = homeRepository.getHomeFeed(lat, lng )){
               is NetworkResult.Loading -> {
                   uiState = UiState.Loading

               }
                is NetworkResult.Success -> {
                    uiState = UiState.Success(result.data)

                }
                is NetworkResult.Error -> {
                    uiState = UiState.Error(result.message)

                }
        }
        }
    }
}