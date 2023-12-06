package com.adnanjelic.simpletvstreamingapp.shared.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adnanjelic.simpletvstreamingapp.shared.storage.dao.CategoriesLocalSource
import com.adnanjelic.simpletvstreamingapp.shared.storage.dao.CategoriesWithMoviesLocalSource
import com.adnanjelic.simpletvstreamingapp.shared.storage.dao.MoviesLocalSource

@Database(entities = [com.adnanjelic.simpletvstreamingapp.shared.storage.model.CategoryDbModel::class, com.adnanjelic.simpletvstreamingapp.shared.storage.model.MovieDbModel::class], version = 1)
abstract class SimpleTvStreamingAppDatabase : RoomDatabase() {

    abstract fun categories(): CategoriesLocalSource

    abstract fun movies(): MoviesLocalSource

    abstract fun categoriesWithMovies(): CategoriesWithMoviesLocalSource
}
