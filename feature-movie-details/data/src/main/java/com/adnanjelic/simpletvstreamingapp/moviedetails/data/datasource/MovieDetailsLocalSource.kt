package com.adnanjelic.simpletvstreamingapp.moviedetails.data.datasource

import com.adnanjelic.simpletvstreamingapp.moviedetails.data.model.MovieDetailsDataModel

interface MovieDetailsLocalSource {
    fun movieDetails(movieId: String): MovieDetailsDataModel
}
