package com.mechta.design_system.components.buttons.icon

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.korem.design_system.component.icon.AppIcon


@Composable
fun AppIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    enabled: Boolean = true,
    size: Dp = 36.dp,
    tintIcon: Color = LocalContentColor.current,
    containerColor: Color = Color.Transparent,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
){

    IconButton(
        modifier = modifier
            .size(size),
        enabled = enabled,
        colors = IconButtonDefaults
            .iconButtonColors(
                containerColor = containerColor,
                contentColor = LocalContentColor.current,
            ),
        interactionSource = interactionSource,
        onClick = {
            onClick()
        },
        content = {
            AppIcon(
                modifier = Modifier
                    .size(size - size/3),
                imageVector = icon,
                tint = tintIcon,
            )
        }
    )
}