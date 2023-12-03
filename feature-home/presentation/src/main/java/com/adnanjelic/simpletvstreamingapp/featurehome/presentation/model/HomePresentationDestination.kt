package com.adnanjelic.simpletvstreamingapp.featurehome.presentation.model

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.navigation.PresentationDestination

internal sealed interface HomePresentationDestination : PresentationDestination {

    data object Back : HomePresentationDestination
}
