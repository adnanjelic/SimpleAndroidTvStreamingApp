package com.adnanjelic.simpletvstreamingapp.architecture.data.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DataModel
import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DbModel

interface DbToDataMapper<INPUT: DbModel, OUTPUT: DataModel> {

    fun toData(input: INPUT): OUTPUT
}
