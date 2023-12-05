package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adnanjelic.simpletvstreamingapp.theme.Dimension

@Composable
fun DefaultSpacer() {
    Spacer(modifier = Modifier.size(Dimension.Padding.Default))
}
