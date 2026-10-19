package feedio.app.android.screen.auth.data.model


data class SendOtpResponse(
    val success : Boolean,
    val message : String,
    val otp : String
)