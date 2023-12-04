package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model.CategoryDbModel
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model.CategoryWithMovies
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriesDao {

    @Transaction
    @Query("SELECT * FROM CategoryDbModel")
    fun categories(): Flow<List<CategoryWithMovies>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategories(categories: List<CategoryDbModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategories(categories: List<CategoryWithMovies>)
}
