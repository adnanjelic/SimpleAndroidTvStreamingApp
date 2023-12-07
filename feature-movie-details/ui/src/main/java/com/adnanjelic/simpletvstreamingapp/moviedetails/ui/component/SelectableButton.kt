package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.component

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.Button
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.R
import com.adnanjelic.simpletvstreamingapp.theme.Green60

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun SelectableButton(
    @StringRes textResourceId: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.colors(focusedContainerColor = Green60)
    ) {
        Text(stringResource(id = textResourceId))
    }
}

@Preview
@Composable
private fun SelectableButtonPreview() {
    SelectableButton(textResourceId = R.string.play_movie_label)
}
