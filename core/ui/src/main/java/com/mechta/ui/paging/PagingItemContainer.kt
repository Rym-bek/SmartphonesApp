package com.mechta.ui.paging

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.mechta.design_system.components.lazy_grid.AppLazyVerticalGrid
import com.mechta.design_system.components.progress_indicator.AppCircularProgressIndicator


@Composable
fun <T : Any> PagingItemContainer(
    modifier: Modifier = Modifier,
    pagingItems: LazyPagingItems<T>,
    itemContent: @Composable (T) -> Unit,
    loadingContent: @Composable (
        modifier: Modifier
    ) -> Unit = {
        AppCircularProgressIndicator(
            modifier = it.padding(16.dp)
        )
    },
) {

    when (pagingItems.loadState.refresh) {
        LoadState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                loadingContent(
                    Modifier.align(Alignment.Center)
                )
            }
        }
        else -> {
            AppLazyVerticalGrid(
                modifier = modifier,
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    count = pagingItems.itemCount,
                ) { index ->
                    val item = pagingItems[index]
                    if (item != null) {
                        itemContent(item)
                    }
                }

                item {
                    when (pagingItems.loadState.append) {
                        LoadState.Loading -> {
                            Box(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                loadingContent(
                                    Modifier.align(Alignment.Center)
                                )
                            }
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}