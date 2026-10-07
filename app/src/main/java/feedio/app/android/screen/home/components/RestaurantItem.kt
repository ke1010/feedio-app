package feedio.app.android.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import feedio.app.android.R
import feedio.app.android.ui.theme.PlusJakartaSans
import feedio.app.android.ui.theme.Teal


@Composable
fun RestaurantItem(modifier : Modifier = Modifier,
                   name : String,
                   address: String,
                    imgRes: String,
                   distanceKm : Double,
                   esTime: String,
                   ratings: Double
                   ){
    Column(modifier = modifier.clip(RoundedCornerShape(10.dp))) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(120.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row(verticalAlignment = Alignment.CenterVertically,
               modifier = Modifier.align(Alignment.BottomEnd)
                   .height(25.dp)
                   .offset(x = (-12).dp, y = (-12).dp)
                   .clip(RoundedCornerShape(16.dp))
                   .background(color = Color.White)
                   .padding(horizontal = 8.dp, vertical = 4.dp)
                   ) {

                Icon(painterResource(R.drawable.clock_icon),
                    contentDescription = "clock")

                Text(
                    text = esTime,
                    fontWeight = FontWeight.Bold,
                    fontFamily = PlusJakartaSans,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(start= 3.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
           modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                color = Color.Black,
                fontFamily = PlusJakartaSans,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
                    .padding(start = 20.dp)

            )

            Text(
                text = ratings.toString(),
                color = Color.Black,
                fontFamily = PlusJakartaSans,
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(end = 10.dp)
            )

            Icon(
                painterResource(R.drawable.star_icon),
                contentDescription = "ratings",
                modifier = Modifier.padding(end = 20.dp)
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = address,
                fontSize = 12.sp,
                fontFamily = PlusJakartaSans,
                color = Color.DarkGray,
                modifier = Modifier.padding(start = 20.dp)
            )

            Text(
                text = "~",
                fontSize = 12.sp,
                fontFamily = PlusJakartaSans,
                color = Color.DarkGray,
                modifier = Modifier.padding(start = 5.dp)
            )


            Text(
                text = distanceKm.toString()+"km",
                fontSize = 12.sp,
                fontFamily = PlusJakartaSans,
                color = Color.DarkGray,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun RestaurantItemPreview() {
    RestaurantItem(
        name = "McDonald's",
        address = "123 Main St, New York",
        imgRes = "",
        distanceKm = 2.5,
        esTime = "20 mins",
        ratings = 4.5
    )
}