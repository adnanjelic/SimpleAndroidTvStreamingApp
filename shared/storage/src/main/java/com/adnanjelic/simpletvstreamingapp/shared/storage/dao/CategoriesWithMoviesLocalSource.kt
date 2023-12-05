package com.adnanjelic.simpletvstreamingapp.shared.storage.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriesWithMoviesLocalSource {

    @Transaction
    @Query("SELECT * FROM CategoryDbModel")
    fun categoriesWithMovies(): Flow<List<com.adnanjelic.simpletvstreamingapp.shared.storage.model.CategoryWithMovies>>
}
