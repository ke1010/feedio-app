package feedio.app.android.network

object ApiResponse {

    data class  SendOtpResponse(
        val message: String,
        val otp : String
    )
}