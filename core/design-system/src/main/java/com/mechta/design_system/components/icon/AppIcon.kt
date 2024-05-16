package com.korem.design_system.component.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp

@Composable
fun AppIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    tint: Color = LocalContentColor.current,
    contentDescription: String = imageVector.name,
    size: Dp = Dp.Unspecified,
    background: Color = Color.Unspecified,
) {
    Icon(
        modifier = modifier
            .size(size)
            .background(background),
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = tint,
    )
}