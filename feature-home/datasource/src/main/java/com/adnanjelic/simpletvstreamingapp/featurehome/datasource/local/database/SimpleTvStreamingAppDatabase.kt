package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model.CategoryDbModel
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model.MovieDbModel

@Database(entities = [CategoryDbModel::class, MovieDbModel::class], version = 1)
abstract class SimpleTvStreamingAppDatabase : RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao
}
