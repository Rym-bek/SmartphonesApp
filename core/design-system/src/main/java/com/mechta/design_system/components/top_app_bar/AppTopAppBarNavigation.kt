package com.mechta.design_system.components.top_app_bar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mechta.design_system.components.buttons.icon.AppIconButton
import com.mechta.design_system.components.text.AppMarqueeText
import com.mechta.design_system.icons.AppIcons

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBarNavigation(
    modifier: Modifier = Modifier,
    title: String = "",
    actions: @Composable RowScope.() -> Unit = {},
    onNavigationClick: () -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors =  TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = backgroundColor,
        navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
        actionIconContentColor = MaterialTheme.colorScheme.onBackground,
    ),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            AppIconButton(
                modifier = Modifier,
                onClick = {
                    onNavigationClick()
                },
                icon = AppIcons.FilledArrowBackIosNew,
            )
        },
        title = {
            AppMarqueeText(
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )
        },
        windowInsets = windowInsets,
        actions = actions,
        colors = colors,
        scrollBehavior = scrollBehavior,
    )
}