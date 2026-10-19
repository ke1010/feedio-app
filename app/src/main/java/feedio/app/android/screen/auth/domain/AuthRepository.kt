package feedio.app.android.screen.auth.domain

import feedio.app.android.network.NetworkResult
import feedio.app.android.screen.auth.data.model.SendOtpResponse
import feedio.app.android.screen.auth.data.model.VerifyOtpRequest
import feedio.app.android.screen.auth.data.model.VerifyOtpResponse

interface AuthRepository {

    suspend fun sendOtp(phoneNumber: String): NetworkResult<SendOtpResponse>

    suspend fun verifyOtp(requestBody: VerifyOtpRequest): NetworkResult<VerifyOtpResponse>
}