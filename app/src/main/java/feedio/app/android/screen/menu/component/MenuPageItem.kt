package feedio.app.android.screen.menu.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun MenuPageItem(modifier: Modifier,
                 imgRes: String,
                 dishName: String,
                 description: String,
                 price: Double,
                 ) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ){
        Row(    modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {

            Column(modifier = Modifier
                .weight(1f)
                .padding(end = 12.dp)) {
                Text(text = dishName,
                    fontFamily = PlusJakartaSans,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(text = price.toString(),
                    fontSize = 12.sp,
                    fontFamily = PlusJakartaSans,
                    color = Color.Black
                )
                Text(text = description,
                    fontFamily = PlusJakartaSans,
                    fontSize = 10.sp,
                    color = Color.Gray)
            }

            Box(contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.size(100.dp)){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = dishName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White,
                    shadowElevation = 4.dp,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "ADD",
                            fontFamily = PlusJakartaSans,
                            color = Teal,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.width(2.dp))

                        Icon(
                            painter = painterResource(R.drawable.add),
                            contentDescription = "Add item",
                            tint = Teal,
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
        }
    }

}
}

@Preview(showBackground = true)
@Composable
fun getPreview(){
    MenuPageItem(modifier = Modifier,
        imgRes = "",
        dishName = "Chicken Biryani",
        description = "khagdsyuqgdiquhboiu",
        price = 12.99)
}