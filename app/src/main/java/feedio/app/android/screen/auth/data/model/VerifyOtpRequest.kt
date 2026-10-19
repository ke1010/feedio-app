package feedio.app.android.screen.auth.data.model

data class VerifyOtpRequest(
    val phoneNo : String,
    val otp : String
) {
}