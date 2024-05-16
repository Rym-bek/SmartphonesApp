package com.mechta.design_system.components.text

import androidx.compose.foundation.DefaultMarqueeDelayMillis
import androidx.compose.foundation.DefaultMarqueeSpacing
import androidx.compose.foundation.DefaultMarqueeVelocity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.basicMarquee
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppMarqueeText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = TextStyle(),
    color: Color = Color.Unspecified,
    animationMode: MarqueeAnimationMode = MarqueeAnimationMode.Immediately,
    iterations: Int = Int.MAX_VALUE,
    spacing: MarqueeSpacing = DefaultMarqueeSpacing,
    velocity: Dp = DefaultMarqueeVelocity,
    initialDelayMillis: Int = DefaultMarqueeDelayMillis,
    textAlign: TextAlign = TextAlign.Start
) {
    AppText(
        modifier = modifier
            .basicMarquee(
                animationMode = animationMode,
                iterations = iterations,
                spacing = spacing,
                velocity = velocity,
                initialDelayMillis = initialDelayMillis
            ),
        text = text,
        style = style,
        color = color,
        maxLines = 1,
        textAlign = textAlign,
    )
}