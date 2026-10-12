package feedio.app.android.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val label: String,
    val icon: Int,
    val route: DashboardRoute
)