package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model

import androidx.room.Embedded
import androidx.room.Relation
import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DbModel

data class CategoryWithMovies(
    @Embedded val category: CategoryDbModel,
    @Relation(
        parentColumn = "id",
        entityColumn = "categoryId"
    )
    val movies: List<MovieDbModel>
) : DbModel
