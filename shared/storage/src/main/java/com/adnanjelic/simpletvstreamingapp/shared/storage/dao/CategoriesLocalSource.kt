package com.adnanjelic.simpletvstreamingapp.shared.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface CategoriesLocalSource {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategories(categories: List<com.adnanjelic.simpletvstreamingapp.shared.storage.model.CategoryDbModel>)
}
