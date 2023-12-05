package com.adnanjelic.simpletvstreamingapp.shared.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MoviesLocalSource {

    @Query("SELECT * FROM MovieDbModel where id = :movieId")
    fun movieDetails(movieId: String): com.adnanjelic.simpletvstreamingapp.shared.storage.model.MovieDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: List<com.adnanjelic.simpletvstreamingapp.shared.storage.model.MovieDbModel>)
}
