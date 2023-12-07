package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.R
import com.adnanjelic.simpletvstreamingapp.shared.ui.component.DarkBackgroundPreview
import com.adnanjelic.simpletvstreamingapp.theme.Dimension

@Composable
internal fun MovieDescription(text: String) {
    Column {

        Label(R.string.description_label)

        Spacer(modifier = Modifier.size(Dimension.Padding.Small))

        ContentText(text)
    }
}

@DarkBackgroundPreview
@Composable
private fun MovieDescriptionPreview() {
    MovieDescription("Some long long text description")
}  
