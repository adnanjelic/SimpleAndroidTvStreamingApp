package com.adnanjelic.simpletvstreamingapp.shared.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.adnanjelic.simpletvstreamingapp.theme.Dimension

@Composable
fun Spacer(size: Dp = Dimension.Padding.Default) {
    Spacer(modifier = Modifier.size(size))
}
