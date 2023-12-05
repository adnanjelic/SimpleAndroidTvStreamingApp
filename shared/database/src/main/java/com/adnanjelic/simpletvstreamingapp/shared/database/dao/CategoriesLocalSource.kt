package com.adnanjelic.simpletvstreamingapp.shared.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.adnanjelic.simpletvstreamingapp.shared.database.model.CategoryDbModel

@Dao
interface CategoriesLocalSource {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategories(categories: List<CategoryDbModel>)
}
