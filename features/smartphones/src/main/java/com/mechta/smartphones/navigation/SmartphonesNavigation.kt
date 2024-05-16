package com.mechta.smartphones.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mechta.smartphones.ui.SmartphonesScreen

const val smartphonesNavigationRoute = "smartphones"

fun NavController.navigateToSmartphones() {
    this.navigate(smartphonesNavigationRoute)
}

fun NavGraphBuilder.smartphonesScreen(
    onNavigateToSmartphoneDetails: (String) -> Unit,
) {
    composable(smartphonesNavigationRoute) {
        SmartphonesScreen(
            onNavigateToSmartphoneDetails = onNavigateToSmartphoneDetails
        )
    }
}