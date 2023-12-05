package com.adnanjelic.simpletvstreamingapp.shared.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [com.adnanjelic.simpletvstreamingapp.shared.storage.model.CategoryDbModel::class, com.adnanjelic.simpletvstreamingapp.shared.storage.model.MovieDbModel::class], version = 1)
abstract class SimpleTvStreamingAppDatabase : RoomDatabase() {

    abstract fun categories(): com.adnanjelic.simpletvstreamingapp.shared.storage.dao.CategoriesLocalSource

    abstract fun movies(): com.adnanjelic.simpletvstreamingapp.shared.storage.dao.MoviesLocalSource

    abstract fun categoriesWithMovies(): com.adnanjelic.simpletvstreamingapp.shared.storage.dao.CategoriesWithMoviesLocalSource
}
