package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model.CategoryWithMovies
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriesWithMoviesDao {

    @Transaction
    @Query("SELECT * FROM CategoryDbModel")
    fun categoriesWithMovies(): Flow<List<CategoryWithMovies>>
}
