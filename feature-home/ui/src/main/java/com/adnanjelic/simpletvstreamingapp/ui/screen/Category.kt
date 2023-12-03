package com.adnanjelic.simpletvstreamingapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import coil.compose.AsyncImage
import com.adnanjelic.simpletvstreamingapp.theme.Dimension
import com.adnanjelic.simpletvstreamingapp.ui.model.MediaCategoryUiModel
import com.adnanjelic.simpletvstreamingapp.ui.model.MediaItemUiModel

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun Category(
    category: MediaCategoryUiModel,
    onItemSelected: (MediaItemUiModel) -> Unit = {},
) {
    Text(
        text = category.name,
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.padding(vertical = Dimension.Padding.Default)
    )
    TvLazyRow(
        horizontalArrangement = Arrangement.spacedBy(Dimension.Padding.Default)
    ) {

        category.items.forEach {
            item(key = it.id) {
                Box(
                    modifier = Modifier.size(150.dp, 200.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    MovieCard(
                        movie = it,
                        onClick = onItemSelected
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

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
internal fun MovieCard(
    movie: MediaItemUiModel,
    onClick: (MediaItemUiModel) -> Unit = {}
) {
    Card(
        onClick = { onClick(movie) }
    ) {
        AsyncImage(
            model = movie.posterUrl,
            modifier = Modifier.fillMaxSize(),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop
        )
    }
}
