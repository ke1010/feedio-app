package feedio.app.android.screen.auth.data.model

data class VerifyOtpResponse(
    val success: Boolean,
    val message : String,
     val phoneNo: String,
     val otp : String
) {
}