package com.adnanjelic.simpletvstreamingapp.di

import com.adnanjelic.simpletvstreamingapp.architecture.domain.UseCaseExecutor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ArchitectureModule {

    @Provides
    fun providesUseCaseExecutor() = UseCaseExecutor()
}
