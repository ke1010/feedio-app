package feedio.app.android.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import feedio.app.android.R
import feedio.app.android.ui.theme.PlusJakartaSans
import feedio.app.android.ui.theme.Teal

@Composable
fun AuthScreen(modifier : Modifier = Modifier) {
    var phoneNumber by remember { mutableStateOf("") }
    Column(
        modifier.fillMaxSize()
            .background(color = Color.White)


    ) {
        Spacer(modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.phoneNo),
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = PlusJakartaSans,
            modifier = modifier.padding(start = 20.dp)
        )

        Spacer(modifier.height(10.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            placeholder = {
                Text(
                    text = "Phone number",
                    color = Color.DarkGray,
                    fontSize = 12.sp
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.DarkGray,
                focusedBorderColor = Teal,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            modifier = modifier.fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier.height(20.dp))

        TextButton(
            onClick = {},
            modifier.fillMaxWidth(0.8f)
                .align(Alignment.CenterHorizontally)
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Teal)
        ) {
            Text(
                text = stringResource(id=R.string.cont),
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = PlusJakartaSans,

                )
        }

        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "By continuing I accept T&C",
            fontSize = 12.sp,
            fontFamily = PlusJakartaSans,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

    }
}






