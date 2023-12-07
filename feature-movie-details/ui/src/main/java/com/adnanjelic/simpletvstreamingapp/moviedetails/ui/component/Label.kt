package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.R
import com.adnanjelic.simpletvstreamingapp.shared.ui.component.DarkBackgroundPreview

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun Label(@StringRes textResourceId: Int) {
    Text(
        stringResource(id = textResourceId),
        color = Color.White,
        style = MaterialTheme.typography.titleMedium
    )
}

@DarkBackgroundPreview
@Composable
private fun LabelPreview() {
    Label(R.string.back_label)
}
