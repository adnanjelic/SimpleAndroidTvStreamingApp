package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.model.MovieDbModel

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: List<MovieDbModel>)
}
