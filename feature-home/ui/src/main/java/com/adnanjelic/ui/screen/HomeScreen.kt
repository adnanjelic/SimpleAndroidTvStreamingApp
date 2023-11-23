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
import com.adnanjelic.ui.model.stubItems

@Composable
fun HomeScreen(onMediaSelected: (String) -> Unit = {}) {
    val categories = stubItems()
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

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
