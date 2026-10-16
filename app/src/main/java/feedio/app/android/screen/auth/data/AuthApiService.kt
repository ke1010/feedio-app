package feedio.app.android.screen.auth.data

import feedio.app.android.network.ApiUrl
import feedio.app.android.screen.auth.ApiResponse
import retrofit2.Response

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST(ApiUrl.SEND_OTP)
    suspend fun sendOtp(@Body requestBody: String) : Response<ApiResponse>
}