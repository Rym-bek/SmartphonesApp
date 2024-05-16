package com.mechta.smartphone_details.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mechta.design_system.components.buttons.icon.AppIconButtonChangeFull
import com.mechta.design_system.components.scaffold.AppScaffold
import com.mechta.design_system.components.text.types.body.TextBodyLarge
import com.mechta.design_system.components.text.types.body.TextBodyMedium
import com.mechta.design_system.components.text.types.label.TextLabelLarge
import com.mechta.design_system.components.text.types.title.TextTitleLarge
import com.mechta.design_system.components.top_app_bar.AppTopAppBarNavigation
import com.mechta.design_system.icons.AppIcons
import com.mechta.smartphone_details.viewmodel.SmartphoneDetailsViewModel
import com.mechta.smartphone_details.viewmodel.events.SmartphoneDetailsEvent
import com.mechta.smartphone_details.viewmodel.states.DetailsUiState
import com.mechta.ui.pager.PhotoPager
import com.mechta.ui_models.SmartphoneDetailsPropertiesUi

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SmartphoneDetailsScreen(
    smartphoneDetailsViewModel: SmartphoneDetailsViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val uiState = smartphoneDetailsViewModel.uiState.collectAsStateWithLifecycle().value
    val detailsUiState = uiState.detailsUiState
    AppScaffold(
        topBar = {
            AppTopAppBarNavigation(
                onNavigationClick = {
                    onBackClick()
                },
                actions = {
                    AppIconButtonChangeFull(
                        firstIcon = AppIcons.FilledFavorite,
                        secondIcon = AppIcons.OutlinedFavorite,
                        selected = when(detailsUiState) {
                            is DetailsUiState.Success -> {
                                detailsUiState.smartphoneDetailsUi.isFavorite
                            }
                            else -> {
                                false
                            }
                        },
                        onClick = {
                            when(detailsUiState) {
                                is DetailsUiState.Success -> {
                                    if(detailsUiState.smartphoneDetailsUi.isFavorite) {
                                        smartphoneDetailsViewModel.onEvent(
                                            SmartphoneDetailsEvent.DeleteFavorite(detailsUiState.smartphoneDetailsUi.id)
                                        )
                                    } else {
                                        smartphoneDetailsViewModel.onEvent(
                                            SmartphoneDetailsEvent.AddFavorite(detailsUiState.smartphoneDetailsUi.id)
                                        )
                                    }
                                }
                                else -> {}
                            }
                        }
                    )
                }
            )
        },
        content = { paddingValues: PaddingValues ->
            when(detailsUiState) {
                is DetailsUiState.Success -> {
                    Column(
                        modifier = Modifier
                            .padding(paddingValues)
                            .verticalScroll(rememberScrollState())
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        PhotoPager(
                            images = detailsUiState.smartphoneDetailsUi.photos
                        )
                        TextBodyLarge(
                            modifier = Modifier
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            text = detailsUiState.smartphoneDetailsUi.title
                        )

                        TextTitleLarge(
                            modifier = Modifier
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            text = "Основное"
                        )

                        SmartphonePropertiesList(
                            properties = detailsUiState.smartphoneDetailsUi.properties
                        )
                    }
                }
                else -> {}
            }
        }
    )
}

@Composable
fun SmartphonePropertiesList(properties: List<SmartphoneDetailsPropertiesUi>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        properties.forEach { property ->
            SmartphonePropertyItem(property = property)
        }
    }
}

@Composable
fun SmartphonePropertyItem(property: SmartphoneDetailsPropertiesUi) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextLabelLarge(
            modifier = Modifier.weight(1f),
            text = property.name,
        )
        TextBodyMedium(
            modifier = Modifier.weight(1f),
            text = property.value,
        )
    }
}