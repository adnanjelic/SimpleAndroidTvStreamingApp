package com.adnanjelic.simpletvstreamingapp.featurehome.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.tv.foundation.lazy.list.TvLazyColumn
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.CategoryUiModel
import com.adnanjelic.simpletvstreamingapp.theme.Dimension

@Composable
internal fun HomeContent(
    isVisible: Boolean,
    categoriesWithMovies: Collection<CategoryUiModel>,
    onMovieSelected: (String) -> Unit = {}
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = expandVertically() + fadeIn(),
        exit = shrinkVertically() + fadeOut()
    ) {
        TvLazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = Dimension.Padding.Big),
//            verticalArrangement = Arrangement.SpaceAround
        ) {
            categoriesWithMovies.forEach { category ->
                item(key = category.id) {
                    CategoryRow(category = category, onMovieSelected = onMovieSelected)
                }
            }
        }
    }
}
