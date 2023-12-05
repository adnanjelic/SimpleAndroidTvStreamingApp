package com.adnanjelic.simpletvstreamingapp.shared.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adnanjelic.simpletvstreamingapp.shared.database.dao.CategoriesLocalSource
import com.adnanjelic.simpletvstreamingapp.shared.database.dao.CategoriesWithMoviesLocalSource
import com.adnanjelic.simpletvstreamingapp.shared.database.dao.MoviesLocalSource
import com.adnanjelic.simpletvstreamingapp.shared.database.model.CategoryDbModel
import com.adnanjelic.simpletvstreamingapp.shared.database.model.MovieDbModel

@Database(entities = [CategoryDbModel::class, MovieDbModel::class], version = 1)
abstract class SimpleTvStreamingAppDatabase : RoomDatabase() {

    abstract fun categories(): CategoriesLocalSource

    abstract fun movies(): MoviesLocalSource

    abstract fun categoriesWithMovies(): CategoriesWithMoviesLocalSource
}
