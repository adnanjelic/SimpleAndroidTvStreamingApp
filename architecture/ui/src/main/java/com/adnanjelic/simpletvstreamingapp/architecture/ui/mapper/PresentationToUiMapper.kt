package com.adnanjelic.simpletvstreamingapp.architecture.ui.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationModel
import com.adnanjelic.simpletvstreamingapp.architecture.ui.model.UiModel

interface PresentationToUiMapper<INPUT: PresentationModel, OUTPUT: UiModel> {

    fun toUi(input: INPUT): OUTPUT
}
