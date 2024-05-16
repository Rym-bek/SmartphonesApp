package com.mechta.design_system.components.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun rememberPagerStateCustom(
    pageCount: Int = 5,
    initialPage: Int = 0,
) = rememberPagerState(
    initialPage = initialPage,
    initialPageOffsetFraction = 0f,
    pageCount = {
        pageCount
    }
)
