package com.adnanjelic.simpletvstreamingapp.architecture.data.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DataModel
import com.adnanjelic.simpletvstreamingapp.architecture.domain.model.DomainModel

interface DataToDomainMapper<INPUT: DataModel, OUTPUT: DomainModel> {

    fun toDomain(input: INPUT): OUTPUT
}
