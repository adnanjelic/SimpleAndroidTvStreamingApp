package com.adnanjelic.simpletvstreamingapp.architecture.data.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DataModel
import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DbModel

interface DataToDbMapper<INPUT: DataModel, OUTPUT: DbModel> {

    fun toDb(input: INPUT): OUTPUT
}
