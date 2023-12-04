package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model.CategoryDbModel

@Dao
interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategories(categories: List<CategoryDbModel>)
}
