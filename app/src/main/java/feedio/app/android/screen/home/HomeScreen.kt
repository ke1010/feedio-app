package feedio.app.android.screen.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import feedio.app.android.R
import feedio.app.android.UiState
import feedio.app.android.screen.home.component.CategoriesItem
import feedio.app.android.screen.home.component.RestaurantItem
import feedio.app.android.screen.home.model.Category
import feedio.app.android.screen.home.model.SectionDto
import feedio.app.android.ui.theme.Back
import feedio.app.android.ui.theme.PlusJakartaSans
import feedio.app.android.ui.theme.Teal

@Composable
fun HomeScreen(modifier : Modifier = Modifier,
               homeViewModel : HomeViewModel = hiltViewModel()
){

    val uiState = homeViewModel.uiState

    var searchText by remember { mutableStateOf("") }
    Column(modifier.fillMaxSize()
        .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier.height(40.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            textStyle = TextStyle(
                color = Color.Black,
                fontFamily = PlusJakartaSans,
                fontSize = 15.sp
            ),
            singleLine = true,
            leadingIcon = {
                Icon(
                    painterResource(R.drawable.search_icon),
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.searchBar),
                    color = Color.DarkGray,
                    fontSize = 15.sp
                )
            },
            modifier = Modifier.height(50.dp)
                .fillMaxWidth(0.9f)
        )
        LazyColumn(modifier = Modifier
                .fillMaxWidth()
            .weight(1f)) {

            when (val state = uiState) {
                is UiState.Loading, is UiState.Idle -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(color = Teal)
                        }
                    }
                }
                is UiState.Success -> {
                    val feedData = state.data

                    feedData.sectionDto.getOrNull(0)?.let { catData ->
                        categorySection(section = catData, onCategoryClick = {})
                    }

                    feedData.sectionDto.getOrNull(1)?.let { restData ->
                        restaurantVerticalSection(section = restData, onRestaurantClick = {})
                    }
                }

                is UiState.Error -> {
                    item {
                        Text(
                            text = state.message,
                            color = Color.Red,
                            fontFamily = PlusJakartaSans,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                }
            }
        }
    }

    }



fun LazyListScope.categorySection(
    section: SectionDto,
    onCategoryClick: (Category) -> Unit
) {
    item(key = "${section.id}_header") {
        Text(
            text = section.title,
            color = Color.Black,
            fontFamily = PlusJakartaSans,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp, bottom = 12.dp, top = 8.dp)
        )
    }
    item(key = "${section.id}_row") {
        LazyRow(modifier = Modifier.height(60.dp)) {
            items(
                items = section.items,
                key = { item -> "${item.id}_${item.name}" }
            ) { category ->
                CategoriesItem(
                    name = category.name,
                    imgUrl = category.imgUrl,
                    onClick = {  }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}


fun LazyListScope.restaurantVerticalSection(
    section: SectionDto,
    onRestaurantClick: (String) -> Unit
) {
    item(key = "${section.id}_header") {
        Text(
            text = section.title,
            color = Color.Black,
            fontFamily = PlusJakartaSans,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp, bottom = 12.dp, top = 8.dp)
        )
    }

    items(
        items = section.items,
        key = { restaurantItem -> restaurantItem.id }
    ) { restaurantItem ->
        RestaurantItem(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 6.dp),
            name = restaurantItem.name,
            address = restaurantItem.address,
            distanceKm = restaurantItem.distanceKm,
            imgUrl = restaurantItem.imgUrl,
            esTime = restaurantItem.eta,
            ratings = restaurantItem.ratings
        )
    }
}