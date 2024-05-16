package com.mechta.smartphones.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.korem.design_system.component.spacers.AppSpacer
import com.mechta.design_system.components.icon.AppIconButtonChange
import com.mechta.design_system.components.text.types.body.TextBodyLarge
import com.mechta.design_system.components.text.types.title.TextTitleLarge
import com.mechta.design_system.icons.AppIcons
import com.mechta.smartphones.viewmodel.events.SmartphonesEvent
import com.mechta.ui.pager.PhotoPager
import com.mechta.ui_models.SmartphoneUi

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SmartphonesItem(
    modifier: Modifier = Modifier,
    smartphoneUi: SmartphoneUi,
    onSmartphoneClick: () -> Unit,
    onEvent: (SmartphonesEvent) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp
                )
            )
            .background(MaterialTheme.colorScheme.background)
            .clickable {
                onSmartphoneClick()
            },
    ) {

        Box {
            AppSpacer()

            PhotoPager(
                images = smartphoneUi.photos,
            )

            Log.d("SmartphonesItem", "${smartphoneUi.isFavorite}")

            AppIconButtonChange(
                modifier = Modifier
                    .align(Alignment.TopEnd),
                firstIcon = AppIcons.FilledFavorite,
                secondIcon = AppIcons.OutlinedFavorite,
                change = smartphoneUi.isFavorite,
                onClick = {
                    if(smartphoneUi.isFavorite) {
                        onEvent(
                            SmartphonesEvent.DeleteFavorite(smartphoneUi.id)
                        )
                    } else {
                        onEvent(
                            SmartphonesEvent.AddFavorite(smartphoneUi.id)
                        )
                    }
                },
            )
        }

        TextBodyLarge(
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    start = 10.dp,
                    end = 10.dp,
                ),
            text = smartphoneUi.title,
            maxLines = 3,
        )

        TextTitleLarge(
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 10.dp,
                    bottom = 5.dp,
                ),
            text = smartphoneUi.price.toString()
        )
    }
}