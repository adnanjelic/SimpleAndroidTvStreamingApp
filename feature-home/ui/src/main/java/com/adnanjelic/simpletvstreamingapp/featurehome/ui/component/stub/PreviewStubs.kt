package com.adnanjelic.simpletvstreamingapp.featurehome.ui.component.stub

import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.CategoryUiModel
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.MovieUiModel

internal val MovieStub1 = MovieUiModel(id = "1", title = "The Dark Knight", posterUrl = "")
internal val MovieStub2 = MovieUiModel(id = "2", title = "The Shawshank Redemption", posterUrl = "")
internal val MovieStub3 = MovieUiModel(id = "3", title = "The Godfather", posterUrl = "")
internal val MovieStub4 = MovieUiModel(id = "4", title = "12 Angry Men\"", posterUrl = "")

private val movies = listOf(MovieStub1, MovieStub2, MovieStub3, MovieStub4)

internal val CategoryStub1 = CategoryUiModel(id = "1", name = "Action", movies = movies)
internal val CategoryStub2 = CategoryUiModel(id = "2", name = "Crime", movies = movies.shuffled())
internal val CategoryStub3 = CategoryUiModel(id = "3", name = "Horror", movies = movies.shuffled())
internal val CategoryStub4 = CategoryUiModel(id = "4", name = "Comedy", movies = movies.shuffled())

internal val CategoriesStub = listOf(CategoryStub1, CategoryStub2, CategoryStub3, CategoryStub4)
