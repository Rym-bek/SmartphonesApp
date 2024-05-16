package com.korem.design_system.component.spacers

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppSpacer(
    size: Dp = 10.dp,
) {
    Spacer(
        modifier = Modifier
            .size(size)
    )
}