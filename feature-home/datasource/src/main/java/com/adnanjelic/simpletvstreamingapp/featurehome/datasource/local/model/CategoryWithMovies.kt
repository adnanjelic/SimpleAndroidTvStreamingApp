package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryWithMovies(
    @Embedded val category: CategoryDbModel,
    @Relation(
        parentColumn = "id",
        entityColumn = "categoryId"
    )
    val movies: List<MovieDbModel>
)
