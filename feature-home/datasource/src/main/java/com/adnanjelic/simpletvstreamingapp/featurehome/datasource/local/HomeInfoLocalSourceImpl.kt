package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local

import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoLocalSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.CategoryDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.data.model.HomeInfoDataModel
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper.CategoryDataToDbModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper.CategoryWithMoviesDbToDataModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper.MovieDataToDbModelMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeInfoLocalSourceImpl(
    private val moviesLocalSource: com.adnanjelic.simpletvstreamingapp.shared.storage.dao.MoviesLocalSource,
    private val categoriesLocalSource: com.adnanjelic.simpletvstreamingapp.shared.storage.dao.CategoriesLocalSource,
    private val categoriesWithMoviesLocalSource: com.adnanjelic.simpletvstreamingapp.shared.storage.dao.CategoriesWithMoviesLocalSource,
    private val categoriesWithMoviesDbToDataMapper: CategoryWithMoviesDbToDataModelMapper,
    private val categoryDataToDbModelMapper: CategoryDataToDbModelMapper,
    private val movieDataToDbModelMapper: MovieDataToDbModelMapper
) : HomeInfoLocalSource {

    override suspend fun homeInfo(): Flow<HomeInfoDataModel?> =
        categoriesWithMoviesLocalSource.categoriesWithMovies().map { categoriesWithMovies ->
            if (categoriesWithMovies.isNotEmpty()) {
                HomeInfoDataModel(
                    categories = categoriesWithMovies.map(categoriesWithMoviesDbToDataMapper::toData)
                )
            } else {
                null
            }
        }

    override suspend fun saveHomeInfo(info: HomeInfoDataModel) {
        saveCategories(info.categories)
        saveMovies(info.categories)
    }

    private fun saveMovies(categories: Collection<CategoryDataModel>) {
        val movieDbModels = categories.flatMap { category ->
            category.items.map { movie ->
                val mapperInput = MovieDataToDbModelMapper.Params(
                    movie = movie,
                    categoryId = category.id
                )
                movieDataToDbModelMapper.toDb(mapperInput)
            }
        }
        moviesLocalSource.saveMovies(movieDbModels)
    }

    private fun saveCategories(categories: Collection<CategoryDataModel>) {
        val categoryDbModels = categories.map(categoryDataToDbModelMapper::toDb)
        categoriesLocalSource.saveCategories(categoryDbModels)
    }
}
