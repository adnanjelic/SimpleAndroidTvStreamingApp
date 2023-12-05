package com.adnanjelic.simpletvstreamingapp.moviedetails.datasource.local

import com.adnanjelic.simpletvstreamingapp.moviedetails.data.datasource.MovieDetailsLocalSource
import com.adnanjelic.simpletvstreamingapp.moviedetails.data.model.MovieDetailsDataModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.datasource.local.mapper.MovieDetailsDbToDataModelMapper

class MovieDetailsLocalSourceImpl(
    private val moviesLocalSource: com.adnanjelic.simpletvstreamingapp.shared.storage.dao.MoviesLocalSource,
    private val movieDetailsMapper: MovieDetailsDbToDataModelMapper
) : MovieDetailsLocalSource {

    override fun movieDetails(movieId: String): MovieDetailsDataModel {
        val dbModel = moviesLocalSource.movieDetails(movieId)
        return movieDetailsMapper.toData(dbModel)
    }
}
