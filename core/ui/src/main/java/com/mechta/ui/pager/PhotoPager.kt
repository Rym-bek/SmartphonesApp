package com.mechta.ui.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mechta.design_system.components.image.AppAsyncImage
import com.mechta.design_system.components.pager.AppHorizontalPager
import com.mechta.design_system.components.pager.rememberPagerStateCustom

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotoPager(
    images: List<String>,
    pagerState: PagerState = rememberPagerStateCustom(
        pageCount = if(images.size >= 6) {
            6
        } else {
            images.size
        }
    ),
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppHorizontalPager(
            modifier = Modifier,
            pagerState = pagerState,
            contentPadding = PaddingValues(
                start = 0.dp,
                end = 0.dp,
            ),
            pageSpacing = 16.dp,
            content = { index: Int ->
                AppAsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1F),
                    url = images[index],
                )
            }
        )

        WormIndicator(
            count = pagerState.pageCount,
            pagerState = pagerState
        )
    }
}