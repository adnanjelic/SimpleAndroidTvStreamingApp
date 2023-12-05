package com.adnanjelic.simpletvstreamingapp.moviedetails.datasource.local

import com.adnanjelic.simpletvstreamingapp.moviedetails.data.datasource.MovieDetailsLocalSource
import com.adnanjelic.simpletvstreamingapp.moviedetails.data.model.MovieDetailsDataModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.datasource.local.mapper.MovieDetailsDbToDataModelMapper
import com.adnanjelic.simpletvstreamingapp.shared.database.SimpleTvStreamingAppDatabase

class MovieDetailsLocalSourceImpl(
    private val database: SimpleTvStreamingAppDatabase,
    private val movieDetailsMapper: MovieDetailsDbToDataModelMapper
) : MovieDetailsLocalSource {

    override fun movieDetails(movieId: String): MovieDetailsDataModel {
        val dbModel = database.moviesDao().movieDetails(movieId)
        return movieDetailsMapper.toData(dbModel)
    }
}
