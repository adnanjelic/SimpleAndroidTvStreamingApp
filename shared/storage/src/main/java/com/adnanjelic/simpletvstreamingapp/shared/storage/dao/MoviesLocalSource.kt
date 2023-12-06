package com.adnanjelic.simpletvstreamingapp.shared.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adnanjelic.simpletvstreamingapp.shared.storage.model.MovieDbModel

@Dao
interface MoviesLocalSource {

    @Query("SELECT * FROM MovieDbModel where id = :movieId")
    fun movieDetails(movieId: String): MovieDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: List<MovieDbModel>)
}
