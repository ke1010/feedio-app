package feedio.app.android.screen.home.model

import androidx.annotation.DrawableRes

data class Category(
    val id: String,
    val name: String,
    @DrawableRes val iconRes: Int
)