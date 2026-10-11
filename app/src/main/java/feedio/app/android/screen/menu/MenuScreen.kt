package feedio.app.android.screen.menu

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import feedio.app.android.R
import feedio.app.android.screen.menu.component.MenuPageItem
import feedio.app.android.screen.menu.model.Menu
import feedio.app.android.ui.theme.PlusJakartaSans

@Composable
fun MenuScreen(modifier: Modifier, name : String,
               address: String,
               distanceKm : Double,
               esTime: String,
               ratings: Double,
               menu: List<Menu>
               ){

    Spacer(modifier.height(40.dp))

    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = name,
                        color = Color.Black,
                        fontFamily = PlusJakartaSans,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = ratings.toString(),
                            color = Color.Black,
                            fontFamily = PlusJakartaSans,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Icon(
                            painter = painterResource(R.drawable.star_icon),
                            contentDescription = "Rating",
                            tint = Color(0xFFFFB800),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Address Text
                Text(
                    text = address,
                    fontFamily = PlusJakartaSans,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Bottom Row: Distance & Estimated Time
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.nav_icon),
                        contentDescription = "Distance",
                        tint = Color.Gray,
                        modifier = Modifier.size(14.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "${distanceKm} km",
                        fontSize = 12.sp,
                        fontFamily = PlusJakartaSans,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Icon(
                        painter = painterResource(R.drawable.clock_icon),
                        contentDescription = "Estimated Time",
                        tint = Color.Gray,
                        modifier = Modifier.size(14.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = esTime,
                        fontSize = 12.sp,
                        fontFamily = PlusJakartaSans,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.DarkGray
                    )
                }
            }
        }

    MenuList(menu)
    }
    }

@Composable()
fun MenuList(menu: List<Menu>){
    LazyColumn() {
       items(
           items = menu,
           key = {menu -> menu.id}
       )
       {
           menu ->
           MenuPageItem(modifier = Modifier,
               dishName = menu.name,
               description = menu.description,
               imgRes = menu.imgUrl,
               price = menu.price)
       }


    }
}

@Composable
fun showMenu(){
    val sampleMenu = listOf(
        Menu(id = 1, name = "Chicken Biryani", description = "Aromatic basmati rice with tender chicken", price = 12.99, imgUrl = "",ratings = 4.5),
        Menu(id = 2, name = "Paneer Tikka", description = "Grilled cottage cheese with spices", price = 9.99, imgUrl = "", ratings = 4.5),
        Menu(id = 3, name = "Butter Chicken", description = "Rich and creamy tomato gravy chicken", price = 14.49, imgUrl = "", ratings = 4.5)
    )

    MenuScreen(
        modifier = Modifier,
        name = "Biryani Club",
        address = "Gajraula Amroha",
        distanceKm = 2.5,
        esTime = "20 mins",
        ratings = 4.5,
        menu = sampleMenu
    )
}



