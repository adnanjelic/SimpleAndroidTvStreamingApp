package com.adnanjelic.simpletvstreamingapp.architecture.presentation.navigation

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationModel

interface PresentationDestination : PresentationModel {
    object Back : PresentationDestination
}
