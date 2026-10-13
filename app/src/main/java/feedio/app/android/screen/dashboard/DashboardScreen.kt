package feedio.app.android.screen.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import feedio.app.android.R
import feedio.app.android.navigation.BottomNavItem
import feedio.app.android.navigation.DashboardRoute
import feedio.app.android.screen.account.AccountScreen
import feedio.app.android.screen.home.HomeScreen
import feedio.app.android.screen.reel.ReelScreen
import feedio.app.android.ui.theme.Back
import feedio.app.android.ui.theme.Teal


@Composable
fun DashBoardScreen(modifier : Modifier = Modifier) {

    val bottomNavController = rememberNavController()

    val items = listOf(
        BottomNavItem(R.drawable.home_icon, DashboardRoute.Home),
        BottomNavItem(R.drawable.reel_icon, DashboardRoute.Reel),
        BottomNavItem( R.drawable.user_icon, DashboardRoute.Account)
    )

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { item ->

                    val selected =
                        currentDestination?.route?.contains(item.route::class.simpleName.toString()) == true

                    NavigationBarItem(
                        icon = {
                         Icon(   painter = painterResource(id = item.icon),
                            contentDescription = null,
                             modifier = Modifier.size(30.dp)
                    )

                               },
                        selected = selected,
                        onClick = {
                            bottomNavController.navigate(item.route) {
                                popUpTo(bottomNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }

                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Teal,
                            unselectedIconColor = Color.DarkGray,
                            indicatorColor = Color.White
                        )
                    )
                }
            }
        },
    ) {
            innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = DashboardRoute.Home,
            modifier = Modifier.padding(innerPadding)

        ) {
            composable<DashboardRoute.Home> { HomeScreen() }
            composable<DashboardRoute.Reel> { ReelScreen() }
            composable<DashboardRoute.Account> { AccountScreen() }
        }
    }
    }
