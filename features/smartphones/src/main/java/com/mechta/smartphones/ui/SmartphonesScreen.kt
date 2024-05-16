package com.mechta.smartphones.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import com.mechta.design_system.components.scaffold.AppScaffold
import com.mechta.design_system.components.top_app_bar.AppTopAppBar
import com.mechta.smartphones.viewmodel.SmartphonesViewModel
import com.mechta.smartphones.viewmodel.states.SmartphonesUiState
import com.mechta.ui.paging.PagingItemContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmartphonesScreen(
    smartphonesViewModel: SmartphonesViewModel = hiltViewModel(),
    onNavigateToSmartphoneDetails: (String) -> Unit,
) {
    val uiState = smartphonesViewModel.uiState.collectAsStateWithLifecycle().value

    val smartphonesPagingItems = smartphonesViewModel.getSmartphones().collectAsLazyPagingItems()

    AppScaffold(
        topBar = {
            AppTopAppBar(
                title = "Смартфоны",
            )
        },
        content = { paddingValues ->
            when (uiState) {
                is SmartphonesUiState.Success -> {
                    PagingItemContainer(
                        modifier = Modifier
                            .padding(paddingValues),
                        pagingItems = smartphonesPagingItems,
                        itemContent = { item ->
                            SmartphonesItem(
                                modifier = Modifier.fillMaxWidth(),
                                smartphoneUi = item,
                                onSmartphoneClick = {
                                    onNavigateToSmartphoneDetails(item.code)
                                },
                                smartphonesViewModel::onEvent,
                            )
                        }
                    )
                }
                else -> {}
            }
        },
    )
}