package com.adnanjelic.simpletvstreamingapp.shared.ui.component

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

@Composable
fun Notification(message: String) {
    val context = LocalContext.current
    LaunchedEffect(key1 = message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
