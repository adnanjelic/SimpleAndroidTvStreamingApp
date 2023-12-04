package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryDbModel(
    @PrimaryKey val id: String,
    val name: String
)
