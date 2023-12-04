package com.adnanjelic.simpletvstreamingapp.di

import com.adnanjelic.simpletvstreamingapp.BuildConfig
import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoLocalSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.datasource.HomeInfoRemoteSource
import com.adnanjelic.simpletvstreamingapp.featurehome.data.mapper.HomeInfoDataToDomainMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.data.repository.HomeInfoRepositoryImpl
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.local.HomeInfoLocalSourceImpl
import com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.HomeInfoRemoteSourceImpl
import com.adnanjelic.simpletvstreamingapp.featurehome.domain.repository.HomeInfoRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private const val API_URL = "some url"

    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    fun providesMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG) {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Provides
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

//    @Provides
//    fun providesRestService(
//        moshiConverterFactory: MoshiConverterFactory,
//        okHttpClient: OkHttpClient
//    ): RestService = Retrofit.Builder()
//        .baseUrl(API_URL)
//        .addConverterFactory(moshiConverterFactory)
//        .client(okHttpClient)
//        .build()
//        .create()

    @Provides
    fun providesHomeInfoLocalSource(): HomeInfoLocalSource =
        HomeInfoLocalSourceImpl()

    @Provides
    fun providesHomeInfoRemoteSource(
//        restService: RestService,
//        companyInfoToDataMapper: CompanyInfoToDataMapper
    ): HomeInfoRemoteSource =
        HomeInfoRemoteSourceImpl()

    @Provides
    fun provides(
        localSource: HomeInfoLocalSource,
        remoteSource: HomeInfoRemoteSource,
        mapper: HomeInfoDataToDomainMapper,
//        companyInfoToDbMapper: CompanyInfoToDbMapper,
//        companyInfoDbToDataMapper: CompanyInfoDbToDataMapper
    ): HomeInfoRepository = HomeInfoRepositoryImpl(
        localSource, remoteSource, mapper
    )

//    @Provides
//    fun providesDatabase(
//        @ApplicationContext applicationContext: Context
//    ): CompanyInfoDatabase = Room.databaseBuilder(
//        applicationContext,
//        CompanyInfoDatabase::class.java,
//        "company-info-database"
//    ).build()
//
//    @Provides
//    fun providesCompanyInfoLocalSource(
//        database: CompanyInfoDatabase
//    ): CompanyInfoLocalSource = database.userDao()
}
