package com.example.knownyc.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.knownyc.presentation.boroughs.BoroughScreen

@Composable
fun AppNavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
        composable(Routes.HOME_SCREEN) {
            BoroughScreen(onBoroughClicked = {borough, title ->
                // TODO: navigate to Parks Screen
//                navController.navigate()
            })
        }
        
        composable(Routes.PARKS_SCREEN) {
            
        }
    }
}