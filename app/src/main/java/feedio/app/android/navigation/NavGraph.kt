package feedio.app.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import feedio.app.android.screen.auth.presentation.AuthScreen
import feedio.app.android.screen.auth.presentation.AuthViewModel
import feedio.app.android.screen.auth.presentation.VerifyOtpScreen
import feedio.app.android.screen.dashboard.DashBoardScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier,
             navController : NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.AuthGraph,
        modifier = modifier
    ){
        navigation<NavRoute.AuthGraph>(startDestination = NavRoute.Auth){
        composable<NavRoute.Auth>{backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(NavRoute.AuthGraph)
            }
            val sharedViewModel: AuthViewModel = hiltViewModel(parentEntry)
            AuthScreen(
                viewModel = sharedViewModel,
                onSendOtpClick = {
                    sharedViewModel.resetState()
                    navController.navigate(NavRoute.VerifyOtp)
                }
            )
        }
            composable<NavRoute.VerifyOtp> { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry(NavRoute.AuthGraph)
                }
                val sharedViewModel: AuthViewModel = hiltViewModel(parentEntry)

                VerifyOtpScreen(
                    authViewModel = sharedViewModel,
                    onVerifyClick = {
                        navController.navigate(NavRoute.Home) {
                            popUpTo<NavRoute.AuthGraph> { inclusive = true }
                        }
                    }
                )
            }
        }


        composable<NavRoute.Home> {
            DashBoardScreen()
        }
    }


}