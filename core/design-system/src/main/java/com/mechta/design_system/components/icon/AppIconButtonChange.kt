package com.mechta.design_system.components.icon

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mechta.design_system.components.buttons.icon.AppIconButton

@Composable
fun AppIconButtonChange(
    modifier: Modifier = Modifier,
    firstIcon: ImageVector,
    secondIcon: ImageVector,
    change: Boolean,
    onClick: () -> Unit,
    enabled: Boolean = true,
    size: Dp = 36.dp,
    firstTintIcon: Color = LocalContentColor.current,
    secondTintIcon: Color = MaterialTheme.colorScheme.primary,
    containerColor: Color = Color.Transparent,
) {
    AppIconButton(
        modifier = modifier,
        onClick = {
            onClick()
        },
        icon = if (change) {
            firstIcon
        } else {
            secondIcon
        },
        containerColor = containerColor,
        tintIcon = if (change) {
            firstTintIcon
        } else {
            secondTintIcon
        },
        enabled = enabled,
        size = size
    )
}