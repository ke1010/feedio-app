package feedio.app.android.screen.auth.data

import feedio.app.android.network.NetworkResult
import feedio.app.android.screen.auth.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: AuthApiService
) : AuthRepository{

    override suspend fun sendOtp(phoneNumber: String): NetworkResult<Unit> {
        return try{
            val response = apiService.sendOtp(phoneNumber)
            if(response.isSuccessful){
                NetworkResult.Success(Unit)
            }else{
                NetworkResult.Error(response.errorBody()?.string() ?: "Failed to send otp")
            }
        }catch (e: Exception){
            NetworkResult.Error(e.localizedMessage ?: "Network error occurred")
        }
    }


}