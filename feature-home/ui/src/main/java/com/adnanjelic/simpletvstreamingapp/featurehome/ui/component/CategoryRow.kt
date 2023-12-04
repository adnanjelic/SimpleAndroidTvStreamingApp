package com.adnanjelic.simpletvstreamingapp.featurehome.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.CategoryUiModel
import com.adnanjelic.simpletvstreamingapp.theme.Dimension

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun CategoryRow(
    category: CategoryUiModel,
    onMovieSelected: (String) -> Unit = {},
) {
    Text(
        text = category.name,
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.padding(bottom = Dimension.Padding.Small)
    )
    TvLazyRow(
        modifier = Modifier.padding(bottom = Dimension.Padding.Big),
        horizontalArrangement = Arrangement.spacedBy(Dimension.Padding.Default)
    ) {
        category.items.forEach {
            item(key = it.id) {
                Box(
                    modifier = Modifier.size(100.dp, 150.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    MovieCard(
                        movie = it,
                        onMovieSelected = onMovieSelected
                    )
                    Text(
                        text = it.title,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}
