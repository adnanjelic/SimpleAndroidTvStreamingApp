package com.adnanjelic.simpletvstreamingapp.shared.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DbModel

@Entity
data class MovieDbModel(
    @PrimaryKey val id: String,
    val categoryId: String,
    val title: String,
    val description: String,
    val posterUrl: String,
    val duration: String,
    val rating: Float,
    val trailerUrl: String
) : DbModel
