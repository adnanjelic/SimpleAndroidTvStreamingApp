package com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper.PresentationToUiNotificationMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomePresentationNotification
import com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model.HomePresentationNotification.UnknownError
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.HomeUiNotification
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.model.HomeUiNotification.ErrorMessage
import javax.inject.Inject

internal class HomeNotificationPresentationToUiModelMapper @Inject constructor() :
    PresentationToUiNotificationMapper<HomePresentationNotification, HomeUiNotification> {

    override fun toUi(input: HomePresentationNotification) = when (input) {
        is UnknownError -> ErrorMessage("Unknown error occurred, please try later") // TODO: Add string to resources
    }
}
