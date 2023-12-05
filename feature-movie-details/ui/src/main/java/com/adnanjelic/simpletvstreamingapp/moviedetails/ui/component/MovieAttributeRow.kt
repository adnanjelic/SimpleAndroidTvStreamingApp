package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.adnanjelic.simpletvstreamingapp.theme.Dimension

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun MovieAttributeRow(@StringRes headerResourceId: Int, text: String) {

    Row(verticalAlignment = Alignment.Bottom) {

        Label(textResourceId = headerResourceId)

        Spacer(modifier = Modifier.size(Dimension.Padding.Small))

        ContentText(text = text)
    }
}
