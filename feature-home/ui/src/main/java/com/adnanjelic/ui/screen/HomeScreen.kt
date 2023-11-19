package com.adnanjelic.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.foundation.lazy.list.TvLazyColumn
import com.adnanjelic.theme.Dimension
import com.adnanjelic.ui.model.MediaCategoryUiModel
import com.adnanjelic.ui.model.MediaItemUiModel

@Composable
fun HomeScreen(onMediaSelected: (String) -> Unit = {}) {
    val categories = stubItems("Category", "Avengers The End Game")
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(start = Dimension.Padding.Big),
//        verticalArrangement = Arrangement.spacedBy(Dimension.Padding.Default)
//    ) {
//        categories.forEach { category ->
//            item(key = category.id) {
//                Text(text = category.name)
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .scrollable(rememberScrollState(), orientation = Orientation.Horizontal),
//                    horizontalArrangement = Arrangement.spacedBy(Dimension.Padding.Default)
//                ) {
//                    category.items.forEach { mediaItem ->
//                        Card(modifier = Modifier.size(150.dp, 200.dp)) {
//                            AsyncImage(
//                                model = mediaItem.posterUrl,
//                                contentDescription = mediaItem.title
//                            )
//                            Text(text = mediaItem.title)
//                        }
//                    }
//                }
//            }
//        }
//    }

    val context = LocalContext.current
    TvLazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = Dimension.Padding.Big),
        verticalArrangement = Arrangement.spacedBy(Dimension.Padding.Default)
    ) {
        categories.forEach { category ->
            item(key = category.id) {
                Category(
                    category = category,
                    onItemSelected = {
                        Toast.makeText(context, "Movie clicked: ${it.title}", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }
        }
    }
}

private fun stubItems(category: String, movieName: String) = (1..6).map { categoryNumber ->
    val movies = (1..12).map { movieNumber ->
        MediaItemUiModel(
            id = movieNumber.toString(),
            title = "Category: $categoryNumber\n Movie: $movieNumber",
            posterUrl = posters.random()
        )
    }
    MediaCategoryUiModel(
        id = categoryNumber.toString(),
        name = "$category $categoryNumber",
        items = movies
    )
}

private val posters = listOf(
    "https://www.closeup-shop.com/media/oart_0/oart_m/oart_14146/1023019_G524780.JPG",
    "https://assets-global.website-files.com/6009ec8cda7f305645c9d91b/6408f6e7b5811271dc883aa8_batman-min.png",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvHewK7CkVROUSV6nDdO5Jg5qvyj4hsmTHcbp3QUw73faWUEnZxzeB8Xzy2LbRjavu-Hs&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLEhz9cl-xEPBqbMFoHNjvKIgCNeJvuixaFlQfhcATU5fPTFPA8x1CXi9fMOFBgqykPOY&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmemzKKVB0fY9LSMGCrirER7gvgAeYfWHYnhK2egnm1BsyWKIoFtiyiMHaPNee69Z5hwY&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-H1SyGc-iERy3rLEk26nEq0UnUA1b6N7MZA&usqp=CAU"
)

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
