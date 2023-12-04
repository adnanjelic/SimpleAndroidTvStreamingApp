package com.adnanjelic.simpletvstreamingapp.architecture.data.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.model.ApiModel
import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DataModel

interface ApiToDataMapper<INPUT : ApiModel, OUTPUT : DataModel> {

    fun toData(input: INPUT): OUTPUT
}
