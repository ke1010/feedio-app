package feedio.app.android.screen.auth.data

import feedio.app.android.network.ApiUrl
import feedio.app.android.screen.auth.data.model.SendOtpResponse
import feedio.app.android.screen.auth.data.model.VerifyOtpRequest
import feedio.app.android.screen.auth.data.model.VerifyOtpResponse
import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApiService {

    @POST(ApiUrl.SEND_OTP)
    suspend fun sendOtp(@Query("phone") phoneNumber: String) : Response<SendOtpResponse>

    @POST(ApiUrl.VERIFY_OTP)
        suspend fun verifyOtp(@Body requestBody: VerifyOtpRequest): Response<VerifyOtpResponse>

}