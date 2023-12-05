package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ContentText(text: String) {
    Text(text = text, color = Color.White, style = MaterialTheme.typography.bodyMedium)
}
