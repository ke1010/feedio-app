package feedio.app.android.screen.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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


@Composable
fun DashBoardScreen(modifier : Modifier = Modifier) {

    val bottomNavController = rememberNavController()

    val items = listOf(
        BottomNavItem("Home", R.drawable.home_icon, DashboardRoute.Home),
        BottomNavItem("Reels", R.drawable.reel_icon, DashboardRoute.Reel),
        BottomNavItem("Account", R.drawable.user_icon, DashboardRoute.Account)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { item ->

                    val selected =
                        currentDestination?.route?.contains(item.route::class.simpleName.toString()) == true

                    NavigationBarItem(
                        icon = {
                         Icon(   painter = painterResource(id = item.icon),
                            contentDescription = item.label
                    )
                               },
                        label = { Text(item.label) },
                        selected = selected,
                        onClick = {
                            bottomNavController.navigate(item.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a massive stack of tabs
                                popUpTo(bottomNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected tab
                                restoreState = true
                            }

                        }
                    )
                }
            }
        }
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
