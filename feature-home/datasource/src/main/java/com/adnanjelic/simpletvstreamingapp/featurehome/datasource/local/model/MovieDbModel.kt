package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieDbModel(
    @PrimaryKey val id: String,
    val categoryId: String,
    val title: String,
    val posterUrl: String
)
