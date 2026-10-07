package feedio.app.android.screen.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import feedio.app.android.R
import feedio.app.android.screen.home.components.CategoriesItem
import feedio.app.android.screen.home.components.RestaurantItem
import feedio.app.android.screen.home.model.Category
import feedio.app.android.screen.home.model.Restaurant
import feedio.app.android.ui.theme.PlusJakartaSans

@Composable
fun HomeScreen(modifier : Modifier = Modifier){
    var searchText by remember { mutableStateOf("") }
    Column(modifier.fillMaxSize()
        .background(Color.White)) {

        OutlinedTextField(
            value = searchText,
            onValueChange = {searchText = it},
            leadingIcon = {
                Icon(
                    painterResource(R.drawable.search_icon),
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
            },
            placeholder = {
                Text(text = stringResource(R.string.searchBar),
                    color = Color.DarkGray,
                    fontSize = 10.sp)
            },
          modifier =  Modifier.height(50.dp)
                .fillMaxWidth(0.8f)
                .align(Alignment.CenterHorizontally)
              .align(Alignment.CenterHorizontally)
        )
    }
}


@Composable
fun Categories(categories: List<Category>,
               onCategoryClick: (Category) -> Unit,
               modifier: Modifier = Modifier){

    Column(modifier.fillMaxWidth()) {
    Text(text = stringResource(R.string.cat),
        color = Color.Black,
        fontFamily = PlusJakartaSans,
        fontWeight = Bold,
        modifier = Modifier.padding(start = 20.dp)
    )

        LazyRow(modifier.height(60.dp)) {
          items(
              items =  categories,
              key = {category -> category.id}
          ){ category ->
              CategoriesItem(
                  title = category.name,
                  imageRes = category.iconRes,
                  onClick = {onCategoryClick(category)}
              )


          }

        }
    }
}

@Composable
fun Restaurants(modifier: Modifier = Modifier, restaurant : List<Restaurant>) {

    Column(modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.restNear),
            color = Color.Black,
            fontFamily = PlusJakartaSans,
            fontWeight = Bold,
            modifier = Modifier.padding(start = 20.dp)
        )

        LazyRow() {
            items(
                items = restaurant,
                key = {}

            ){
                restaurant ->
            }

        }
    }
}