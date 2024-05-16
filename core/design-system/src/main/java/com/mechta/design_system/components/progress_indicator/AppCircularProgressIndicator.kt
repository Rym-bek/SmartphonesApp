package com.mechta.design_system.components.progress_indicator

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PreviewAppCircularProgressIndicator() {
    AppCircularProgressIndicator(
        modifier = Modifier,
        size = 100.dp,
    )
}

@Composable
fun AppCircularProgressIndicator(
    modifier: Modifier = Modifier,
    size: Dp = 100.dp
) {
    CircularProgressIndicator(
        modifier = modifier
            .size(size),
        color = MaterialTheme.colorScheme.surfaceVariant,
        trackColor = MaterialTheme.colorScheme.secondary,
    )
}

