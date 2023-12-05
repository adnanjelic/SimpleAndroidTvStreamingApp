package com.adnanjelic.simpletvstreamingapp.di

import android.content.Context
import androidx.room.Room
import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoLocalSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoRemoteSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.mapper.HomeInfoDataToDomainMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.repository.HomeInfoRepositoryImpl
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.HomeInfoLocalSourceImpl
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.database.SimpleTvStreamingAppDatabase
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper.CategoryDataToDbModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper.CategoryWithMoviesDbToDataModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.mapper.MovieDataToDbModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.HomeInfoRemoteSourceImpl
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.mapper.CategoryApiToDataModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.repository.HomeInfoRepository
import com.adnanjelic.simpletvstreamingapp.moviedetails.data.repository.MovieDetailsRepositoryImpl
import com.adnanjelic.simpletvstreamingapp.moviedetails.domain.repository.MovieDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun providesHomeInfoRepository(
        localSource: HomeInfoLocalSource,
        remoteSource: HomeInfoRemoteSource,
        mapper: HomeInfoDataToDomainMapper,
    ): HomeInfoRepository = HomeInfoRepositoryImpl(
        localSource, remoteSource, mapper
    )

    @Provides
    fun providesHomeInfoLocalSource(
        database: SimpleTvStreamingAppDatabase,
        categoriesWithMoviesDbToDataMapper: CategoryWithMoviesDbToDataModelMapper,
        categoryDataToDbModelMapper: CategoryDataToDbModelMapper,
        movieDataToDbModelMapper: MovieDataToDbModelMapper
    ): HomeInfoLocalSource = HomeInfoLocalSourceImpl(
        database,
        categoriesWithMoviesDbToDataMapper,
        categoryDataToDbModelMapper,
        movieDataToDbModelMapper
    )

    @Provides
    fun providesHomeInfoRemoteSource(categoryMapper: CategoryApiToDataModelMapper): HomeInfoRemoteSource =
        HomeInfoRemoteSourceImpl(categoryMapper)

    @Provides
    fun providesDatabase(
        @ApplicationContext applicationContext: Context
    ): SimpleTvStreamingAppDatabase = Room.databaseBuilder(
        context = applicationContext,
        klass = SimpleTvStreamingAppDatabase::class.java,
        name = "SimpleTvStreamingAppDatabase"
    ).build()

    @Provides
    fun providesMovieDetailsRepository(
    ): MovieDetailsRepository = MovieDetailsRepositoryImpl(

    )
}
