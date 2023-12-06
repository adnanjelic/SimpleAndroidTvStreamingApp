package com.adnanjelic.simpletvstreamingapp.moviedetails.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper.PresentationToUiNotificationMapper
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationNotification
import com.adnanjelic.simpletvstreamingapp.moviedetails.presentation.model.MovieDetailsPresentationNotification.UnknownError
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.model.MovieDetailsUiNotification
import com.adnanjelic.simpletvstreamingapp.moviedetails.ui.model.MovieDetailsUiNotification.ErrorMessage
import javax.inject.Inject

internal class MovieDetailsNotificationPresentationToUiModelMapper @Inject constructor() :
    PresentationToUiNotificationMapper<MovieDetailsPresentationNotification, MovieDetailsUiNotification> {

    override fun toUi(input: MovieDetailsPresentationNotification) = when (input) {
        is UnknownError -> ErrorMessage("Unknown error occurred, please try later") // TODO: Add string to resources
    }
}
