package feedio.app.android.screen.auth.data

import android.net.Network
import feedio.app.android.network.NetworkResult
import feedio.app.android.screen.auth.data.model.SendOtpResponse
import feedio.app.android.screen.auth.data.model.VerifyOtpRequest
import feedio.app.android.screen.auth.data.model.VerifyOtpResponse
import feedio.app.android.screen.auth.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApiService: AuthApiService
) : AuthRepository{

    override suspend fun sendOtp(phoneNumber: String): NetworkResult<SendOtpResponse> {
        return try {
            val response = authApiService.sendOtp(phoneNumber)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null && body.success) {
                    NetworkResult.Success(body)
                } else {
                    NetworkResult.Error(body?.message ?: "Invalid OTP entered")
                }
            } else {
                NetworkResult.Error(response.errorBody()?.string() ?: "Process failed")
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.localizedMessage ?: "Network error occurred")
        }
    }

    override suspend fun verifyOtp(requestBody: VerifyOtpRequest): NetworkResult<VerifyOtpResponse> {
        return try {
            val response = authApiService.verifyOtp(requestBody)
             if(response.isSuccessful) {
                 val body = response.body()
                 if (body != null && body.success) {
                     NetworkResult.Success(body)
                 } else {
                     NetworkResult.Error(response.errorBody()?.string() ?: "Invalid Otp")
                 }
             } else {
                 NetworkResult.Error(response.errorBody()?.string() ?: "Verification failed")
             }
        }catch (e: Exception){
            NetworkResult.Error(e.localizedMessage?: "Network error occured")
        }
    }
}