package feedio.app.android.screen.auth.data

import android.net.Network
import feedio.app.android.network.NetworkResult
import feedio.app.android.screen.auth.data.model.SendOtpResponse
import feedio.app.android.screen.auth.data.model.VerifyOtpRequest
import feedio.app.android.screen.auth.data.model.VerifyOtpResponse
import feedio.app.android.screen.auth.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: AuthApiService
) : AuthRepository{

    override suspend fun sendOtp(phoneNumber: String): NetworkResult<SendOtpResponse> {
        return try{
            val response = apiService.sendOtp(phoneNumber)
            val body = response.body()
            if (body != null) {
                NetworkResult.Success(body)
            }else{
                NetworkResult.Error(response.errorBody()?.string() ?: "Failed to send otp")
            }
        }catch (e: Exception){
            NetworkResult.Error(e.localizedMessage ?: "Network error occurred")
        }
    }

    override suspend fun verifyOtp(requestBody: VerifyOtpRequest): NetworkResult<VerifyOtpResponse> {
        return try {
            val response = apiService.verifyOtp(requestBody)
                val data = response.body()
                if(data != null){
                    NetworkResult.Success(data)
                }else{
                    NetworkResult.Error(response.errorBody()?.string()?: "Failed to verify")
                }

        }catch (e: Exception){
            NetworkResult.Error(e.localizedMessage?: "Network error occured")
        }
    }
}