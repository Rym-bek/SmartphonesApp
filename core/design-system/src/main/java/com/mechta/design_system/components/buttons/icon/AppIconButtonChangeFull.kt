package com.mechta.design_system.components.buttons.icon

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppIconButtonChangeFull(
    modifier: Modifier = Modifier,
    firstIcon: ImageVector,
    secondIcon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit,
    enabled: Boolean = true,
    size: Dp = 36.dp,
    tintIconDefault: Color = LocalContentColor.current,
    tintIconSelected: Color = MaterialTheme.colorScheme.primary,
    containerColor: Color = Color.Transparent,
) {
    AppIconButton(
        modifier = modifier,
        onClick = {
            onClick()
        },
        icon = if (selected) {
            firstIcon
        } else {
            secondIcon
        },
        containerColor = containerColor,
        tintIcon =
        if(selected) {
            tintIconSelected
        } else {
            tintIconDefault
        },
        enabled = enabled,
        size = size
    )
}