package com.adnanjelic.simpletvstreamingapp.architecture.presentation.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.domain.model.DomainModel
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.model.PresentationModel

interface DomainToPresentationMapper<INPUT: DomainModel, OUTPUT: PresentationModel> {

    fun toPresentation(input: INPUT): OUTPUT
}
