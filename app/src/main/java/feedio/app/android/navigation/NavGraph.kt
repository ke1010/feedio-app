package feedio.app.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import feedio.app.android.screen.auth.presentation.AuthScreen
import feedio.app.android.screen.auth.VerifyOtpScreen
import feedio.app.android.screen.dashboard.DashBoardScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier,
             navController : NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Auth,
        modifier = modifier
    ){
        composable<NavRoute.Auth>{


            AuthScreen(
                onSendOtpClick = { phone ->
                    navController.navigate(NavRoute.VerifyOtp(phoneNumber = phone))
                }
            )
        }
        composable<NavRoute.VerifyOtp> { backStackEntry ->
            val args = backStackEntry.toRoute<NavRoute.VerifyOtp>()

            VerifyOtpScreen(
                onVerifyClick = {
                    navController.navigate(MainDashboardRoute)
                }
                    )
                }


        composable<MainDashboardRoute> {
            DashBoardScreen()
        }
    }


}