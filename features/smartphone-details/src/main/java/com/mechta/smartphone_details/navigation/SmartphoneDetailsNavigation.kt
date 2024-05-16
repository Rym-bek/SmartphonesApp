package com.mechta.smartphone_details.navigation

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mechta.smartphone_details.ui.SmartphoneDetailsScreen

const val smartphoneDetailsNavigationRoute = "smartphone_details"

@VisibleForTesting
val indexArg: String = "index"

fun NavController.navigateToSmartphoneDetails(
    code: String,
) {
    this.navigate("${smartphoneDetailsNavigationRoute}/${code}") {
        launchSingleTop = true
    }
}

class SmartphoneDetailsArgs(
    val code: String,
) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(checkNotNull(savedStateHandle.get<String>(indexArg)))
}

fun NavGraphBuilder.smartphoneDetailsScreen(
    onBackClick: () -> Unit,
) {
    composable(
        route = "${smartphoneDetailsNavigationRoute}/{$indexArg}",
        arguments = listOf(
            navArgument(indexArg) {
                type = NavType.StringType
                defaultValue = ""
            },
        ),
    ) {
        SmartphoneDetailsScreen(
            onBackClick = onBackClick,
        )
    }
}