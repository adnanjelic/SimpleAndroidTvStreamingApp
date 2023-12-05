package com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationModel
import com.adnanjelic.simpletvstreamingapp.shared.navigation.model.NavigationDestination

interface DestinationPresentationToNavigationMapper<INPUT : PresentationModel, OUTPUT : NavigationDestination> {

    fun toDestination(input: INPUT): OUTPUT
}
