package com.adnanjelic.simpletvstreamingapp.shared.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.adnanjelic.simpletvstreamingapp.shared.database.model.MovieDbModel

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: List<MovieDbModel>)
}
