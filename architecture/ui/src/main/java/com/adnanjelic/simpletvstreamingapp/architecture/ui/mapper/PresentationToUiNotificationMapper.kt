package com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationNotification
import com.adnanjelic.simpletvstreamingapp.architecture.ui.model.UiNotification

interface PresentationToUiNotificationMapper<INPUT : PresentationNotification, OUTPUT : UiNotification> {

    fun toUi(input: INPUT): OUTPUT
}
