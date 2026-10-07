package feedio.app.android.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import feedio.app.android.R
import feedio.app.android.ui.theme.PlusJakartaSans
import feedio.app.android.ui.theme.Teal

@Composable
fun VerifyOtpScreen(modifier: Modifier = Modifier){

    Column(modifier.fillMaxSize()
        .background(Color.White)) {

        Text(text = stringResource(id = R.string.verifyOtp),
            fontSize = 16.sp,
            fontFamily = PlusJakartaSans,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        OtpBoxes(
            otpLength = 5,
            onOtpComplete = { fullOtp ->
            }

        )

        Spacer(modifier = Modifier.height(20.dp))

        verifyButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.resendOtp),
            fontSize = 14.sp,
            color = Color.Gray,
            fontFamily = PlusJakartaSans,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }
}

@Composable
fun OtpBoxes(
    otpLength: Int = 5,
    onOtpComplete: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val otpValues = remember { mutableStateListOf(*Array(otpLength) { "" }) }

    val focusRequesters = remember { List(otpLength) { FocusRequester() } }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for(index in 0 until otpLength) {
            OutlinedTextField(
                value = otpValues[index],
                onValueChange = { newValue ->
                    if (newValue.length <= 1) {
                        otpValues[index] = newValue

                        if (newValue.isNotEmpty() && index < otpLength - 1) {
                            focusRequesters[index + 1].requestFocus()
                        }

                        val completeOtp = otpValues.joinToString("")
                        if (completeOtp.length == otpLength) {
                            onOtpComplete(completeOtp)
                        }
                    }
                },
                modifier = Modifier
                    .size(56.dp)
                    .focusRequester(focusRequesters[index]),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Teal,
                    unfocusedBorderColor = Color.DarkGray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White

                ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontFamily = PlusJakartaSans
                )
            )
        }
    }
}

@Composable
fun verifyButton(onClick: () -> Unit, modifier : Modifier = Modifier){

    TextButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Teal)
    ) {
        Text(
            text = stringResource(id = R.string.cont),
            color = Color.White,
            fontSize = 14.sp,
            fontFamily = PlusJakartaSans
        )
    }

}



