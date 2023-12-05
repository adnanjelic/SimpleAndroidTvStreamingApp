package com.adnanjelic.simpletvstreamingapp.shared.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adnanjelic.simpletvstreamingapp.shared.database.dao.CategoriesDao
import com.adnanjelic.simpletvstreamingapp.shared.database.dao.CategoriesWithMoviesDao
import com.adnanjelic.simpletvstreamingapp.shared.database.dao.MoviesDao
import com.adnanjelic.simpletvstreamingapp.shared.database.model.CategoryDbModel
import com.adnanjelic.simpletvstreamingapp.shared.database.model.MovieDbModel

@Database(entities = [CategoryDbModel::class, MovieDbModel::class], version = 1)
abstract class SimpleTvStreamingAppDatabase : RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao

    abstract fun moviesDao(): MoviesDao

    abstract fun categoriesWithMoviesDao(): CategoriesWithMoviesDao
}
