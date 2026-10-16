package feedio.app.android.screen.auth.domain

import feedio.app.android.network.NetworkResult

interface AuthRepository {

    suspend fun sendOtp(phoneNumber: String): NetworkResult<Unit>
}