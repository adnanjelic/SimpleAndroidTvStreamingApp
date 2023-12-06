package com.adnanjelic.simpletvstreamingapp.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource

private val DarkColorScheme
    @Composable get() = darkColorScheme(
        primary = colorResource(R.color.primary),
        onPrimary = colorResource(R.color.onPrimary),
        primaryContainer = colorResource(R.color.primaryContainer),
        onPrimaryContainer = colorResource(R.color.onPrimaryContainer),
        secondary = colorResource(R.color.secondary),
        onSecondary = colorResource(R.color.onSecondary),
        secondaryContainer = colorResource(R.color.secondaryContainer),
        onSecondaryContainer = colorResource(R.color.onSecondaryContainer),
        tertiary = colorResource(R.color.tertiary),
        onTertiary = colorResource(R.color.onTertiary),
        tertiaryContainer = colorResource(R.color.tertiaryContainer),
        onTertiaryContainer = colorResource(R.color.onTertiaryContainer),
        background = colorResource(R.color.background),
        onBackground = colorResource(R.color.onBackground),
        surface = colorResource(R.color.surface),
        onSurface = colorResource(R.color.onSurface),
        surfaceVariant = colorResource(R.color.surfaceVariant),
        onSurfaceVariant = colorResource(R.color.onSurfaceVariant),
        error = colorResource(R.color.error),
        onError = colorResource(R.color.onError),
        errorContainer = colorResource(R.color.errorContainer),
        onErrorContainer = colorResource(R.color.onErrorContainer),
    )

@Composable
fun SimpleTvStreamingAppTheme(
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val context = LocalContext.current
        dynamicDarkColorScheme(context)
    } else {
        DarkColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
