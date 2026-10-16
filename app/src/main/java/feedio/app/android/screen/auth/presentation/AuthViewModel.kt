package feedio.app.android.screen.auth.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import feedio.app.android.UiState
import feedio.app.android.network.NetworkResult
import feedio.app.android.screen.auth.domain.AuthRepository
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {

    var phoneNumber by mutableStateOf("")
        private set

    var uiState by mutableStateOf<UiState<Unit>>(UiState.Idle)
        private set

    fun onPhoneNumberEdit(newNumber : String){
     phoneNumber =newNumber
        if (uiState is UiState.Error) {
            uiState = UiState.Idle
        }
    }

    fun sendOtp() {
        if (uiState is UiState.Loading) return
        if (phoneNumber.isBlank() || phoneNumber.length < 10) {
            uiState = UiState.Error("Please Enter a Valid Number")
            Log.d(phoneNumber, "Number Not valid")
            return
        }

        viewModelScope.launch {
            uiState = UiState.Loading

            when(val result = authRepository.sendOtp(phoneNumber)){
               is NetworkResult.Loading -> {
                   uiState = UiState.Loading
               }

                is NetworkResult.Success ->{
                    uiState = UiState.Success(Unit)
                    Log.d("Success",result.data.toString() )
                }
                is NetworkResult.Error -> {
                    uiState = UiState.Error(result.message)

                }
            }

        }
    }


}