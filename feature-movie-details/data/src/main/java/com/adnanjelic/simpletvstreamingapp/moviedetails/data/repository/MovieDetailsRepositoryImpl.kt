package com.adnanjelic.simpletvstreamingapp.moviedetails.data.repository

import com.adnanjelic.simpletvstreamingapp.moviedetails.domain.model.MovieDetailsDomainModel
import com.adnanjelic.simpletvstreamingapp.moviedetails.domain.repository.MovieDetailsRepository

class MovieDetailsRepositoryImpl : MovieDetailsRepository {

    override suspend fun movieDetails(movieId: String) = MovieDetailsDomainModel(
        id = "281",
        title = "Mission: Impossible - Dead Reckoning Part One",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        posterUrl = "https://www.closeup-shop.com/media/oart_0/oart_m/oart_14146/1023019_G524780.JPG",
        duration = "1:55:33",
        rating = 9.11f
    )
}