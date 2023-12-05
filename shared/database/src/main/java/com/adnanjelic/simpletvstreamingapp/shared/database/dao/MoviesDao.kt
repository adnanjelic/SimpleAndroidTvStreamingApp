package com.adnanjelic.simpletvstreamingapp.shared.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adnanjelic.simpletvstreamingapp.shared.database.model.MovieDbModel

@Dao
interface MoviesDao {

    @Query("SELECT * FROM MovieDbModel where id = :movieId")
    fun movieDetails(movieId: String): MovieDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: List<MovieDbModel>)
}
