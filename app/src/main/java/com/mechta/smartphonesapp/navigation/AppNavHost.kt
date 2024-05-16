package com.mechta.smartphonesapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mechta.smartphone_details.navigation.navigateToSmartphoneDetails
import com.mechta.smartphone_details.navigation.smartphoneDetailsScreen
import com.mechta.smartphones.navigation.smartphonesNavigationRoute
import com.mechta.smartphones.navigation.smartphonesScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val onBackClick: () -> Unit = {
        navController.popBackStack()
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = smartphonesNavigationRoute,
    ) {
        smartphonesScreen(
            onNavigateToSmartphoneDetails = navController::navigateToSmartphoneDetails
        )
        smartphoneDetailsScreen(
            onBackClick = onBackClick
        )
    }
}