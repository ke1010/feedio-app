package feedio.app.android.screen.home.component

import android.graphics.drawable.Icon
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import coil3.compose.SubcomposeAsyncImage
import feedio.app.android.R
import feedio.app.android.ui.theme.Gold
import feedio.app.android.ui.theme.PlusJakartaSans
import feedio.app.android.ui.theme.Teal
import feedio.app.android.util.shimmerEffect


@Composable
fun RestaurantItem(modifier : Modifier = Modifier,
                   name : String,
                   address: String,
                    imgUrl: String,
                   distanceKm : Double,
                   esTime: String,
                   ratings: Double
                   ) {
    Card(modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                SubcomposeAsyncImage(
                    model = imgUrl,
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    loading = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .shimmerEffect()
                        )
                    },
                    error = {
                        Icon(
                            painter = painterResource(R.drawable.broken_img),
                            contentDescription = "error"
                        )
                    }

                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = (-12).dp, y = (-12).dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = Color.White)
                        .padding(horizontal = 8.dp, vertical = 6.dp)
                ) {

                    Icon(
                        painterResource(R.drawable.clock_icon),
                        contentDescription = "clock",
                        tint = Teal
                    )

                    Text(
                        text = esTime,
                        fontWeight = FontWeight.Bold,
                        fontFamily = PlusJakartaSans,
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 5.dp)
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
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 20.dp)

                )

                Text(
                    text = ratings.toString(),
                    color = Color.Black,
                    fontFamily = PlusJakartaSans,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(end = 5.dp)
                )

                Icon(
                    painterResource(R.drawable.star_icon),
                    contentDescription = "ratings",
                    tint = Gold,
                    modifier = Modifier.padding(end = 20.dp)
                )

            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,

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
                    text = distanceKm.toString() + "km",
                    fontSize = 12.sp,
                    fontFamily = PlusJakartaSans,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }

    }
}
