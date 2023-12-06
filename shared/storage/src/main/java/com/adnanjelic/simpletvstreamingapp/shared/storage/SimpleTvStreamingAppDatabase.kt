package com.adnanjelic.simpletvstreamingapp.shared.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adnanjelic.simpletvstreamingapp.shared.storage.dao.CategoriesLocalSource
import com.adnanjelic.simpletvstreamingapp.shared.storage.dao.CategoriesWithMoviesLocalSource
import com.adnanjelic.simpletvstreamingapp.shared.storage.dao.MoviesLocalSource
import com.adnanjelic.simpletvstreamingapp.shared.storage.model.CategoryDbModel
import com.adnanjelic.simpletvstreamingapp.shared.storage.model.MovieDbModel

@Database(entities = [CategoryDbModel::class, MovieDbModel::class], version = 1)
abstract class SimpleTvStreamingAppDatabase : RoomDatabase() {

    abstract fun categories(): CategoriesLocalSource

    abstract fun movies(): MoviesLocalSource

    abstract fun categoriesWithMovies(): CategoriesWithMoviesLocalSource
}
