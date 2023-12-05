package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper

import com.adnanjelic.simpletvstreamingapp.architecture.data.mapper.DataToDbMapper
import com.adnanjelic.simpletvstreamingapp.architecture.data.model.DataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.MovieDataModel
import com.adnanjelic.simpletvstreamingapp.shared.database.model.MovieDbModel
import javax.inject.Inject

class MovieDataToDbModelMapper @Inject constructor() :
    DataToDbMapper<MovieDataToDbModelMapper.Params, MovieDbModel> {

    override fun toDb(input: Params) = MovieDbModel(
        id = input.movie.id,
        categoryId = input.categoryId,
        title = input.movie.title,
        posterUrl = input.movie.posterUrl
    )

    data class Params(val movie: MovieDataModel, val categoryId: String) : DataModel
}
