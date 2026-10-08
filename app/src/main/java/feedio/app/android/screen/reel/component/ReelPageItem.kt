package feedio.app.android.screen.reel.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import feedio.app.android.R
import feedio.app.android.ui.theme.PlusJakartaSans
import feedio.app.android.ui.theme.Teal

@Composable
fun ReelPageItem(modifier: Modifier = Modifier,
                 name : String,
                 ratings: Double,
                 likes : String,
                 cmnts : String,
                 caption : String) {
    Box(modifier = modifier.fillMaxSize()) {

        // 1. Bottom Scrim Gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.85f))
                    )
                )
        )

        // 2. Right Side Action Bar (Elevated independently into the Thumb Zone)
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd) // Independent Box Alignment
                .padding(end = 16.dp, bottom = 140.dp), // Lifted up for ergonomic thumb reach
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ReelActionButton(
                iconRes = R.drawable.heart_icon,
                label = likes,
                onClick = {}
            )

            ReelActionButton(
                iconRes = R.drawable.cmnt_icon,
                label = cmnts,
                onClick = {}
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth(0.75f)
                .padding(start = 16.dp, bottom = 24.dp)
        ) {
            Text(
                text = "$name  ★ $ratings",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                fontFamily = PlusJakartaSans
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = caption,
                color = Color.White.copy(alpha = 0.9f),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                fontFamily = PlusJakartaSans,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {},
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Teal),
                modifier = Modifier.height(38.dp)
            ) {
                Text(
                    text = "Order Now",
                    fontFamily = PlusJakartaSans,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    color = Color.White
                )
            }
        }
    }
        }



@Composable
private fun ReelActionButton(
    iconRes: Int,
    label: String,
    onClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = onClick) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = label,
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }
        Text(
            text = label,
            fontFamily = PlusJakartaSans,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ReelPageItemView(){
 ReelPageItem(Modifier,
     "The Burger Joint",
     4.5,
     "127",
     "32",
     "Looks trippicious")
}
