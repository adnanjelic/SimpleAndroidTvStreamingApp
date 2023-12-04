package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DbModel

@Entity
data class MovieDbModel(
    @PrimaryKey val id: String,
    val categoryId: String,
    val title: String,
    val posterUrl: String
) : DbModel
