package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local

import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoLocalSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.CategoryDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.HomeInfoDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.database.SimpleTvStreamingAppDatabase
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper.CategoryDataToDbModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper.CategoryWithMoviesDbToDataModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper.MovieDataToDbModelMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeInfoLocalSourceImpl(
    private val database: SimpleTvStreamingAppDatabase,
    private val categoriesWithMoviesDbToDataMapper: CategoryWithMoviesDbToDataModelMapper,
    private val categoryDataToDbModelMapper: CategoryDataToDbModelMapper,
    private val movieDataToDbModelMapper: MovieDataToDbModelMapper
) : HomeInfoLocalSource {

    override suspend fun homeInfo(): Flow<HomeInfoDataModel?> =
        database.categoriesWithMoviesDao().categoriesWithMovies().map { categoryWithMovies ->
            HomeInfoDataModel(categories = categoryWithMovies.map(categoriesWithMoviesDbToDataMapper::toData))
        }

    override suspend fun saveHomeInfo(info: HomeInfoDataModel) {
        saveCategories(info.categories)
        saveMovies(info.categories)
    }

    private fun saveMovies(categories: Collection<CategoryDataModel>) {
        val movies = categories.flatMap { category ->
            category.items.map { movie ->
                val mapperInput = MovieDataToDbModelMapper.Params(
                    movie = movie,
                    categoryId = category.id
                )
                movieDataToDbModelMapper.toDb(mapperInput)
            }
        }
        database.moviesDao().saveMovies(movies)
    }

    private fun saveCategories(categories: Collection<CategoryDataModel>) {
        val categories = categories.map(categoryDataToDbModelMapper::toDb)
        database.categoriesDao().saveCategories(categories)
    }
}
