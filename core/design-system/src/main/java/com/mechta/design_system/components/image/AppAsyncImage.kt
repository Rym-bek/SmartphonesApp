package com.mechta.design_system.components.image

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import com.mechta.design_system.icons.AppIcons

@Composable
fun AppAsyncImage(
    modifier: Modifier = Modifier,
    size: Dp = Dp.Unspecified,
    url: Any?,
    cornerRadius : Int = 0,
    context: Context = LocalContext.current,
    contentDescription: String? = "Image",
    placeholder: ImageVector = AppIcons.OutlinedErrorOutline,
    error: ImageVector = AppIcons.OutlinedErrorOutline,
    fallback: ImageVector = error,
    onLoading: ((AsyncImagePainter.State.Loading) -> Unit)? = null,
    onSuccess: ((AsyncImagePainter.State.Success) -> Unit)? = null,
    onError: ((AsyncImagePainter.State.Error) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop, //Fit
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = FilterQuality.None,
){
    val model = ImageRequest.Builder(context)
        .data(url)
        .crossfade(true)
        .build()

    AsyncImage(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(percent = cornerRadius))
            .background(MaterialTheme.colorScheme.background),
        model = model,
        contentDescription = contentDescription,
        placeholder = rememberVectorPainter(placeholder),
        error = rememberVectorPainter(error),
        fallback = rememberVectorPainter(fallback),
        onLoading = onLoading,
        onSuccess = onSuccess,
        onError = onError,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        filterQuality = filterQuality,
    )
}