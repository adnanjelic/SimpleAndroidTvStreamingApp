package com.adnanjelic.simpletvstreamingapp.di

import com.adnanjelic.simpletvstreamingapp.videoplayer.ui.player.VideoPlayer
import com.adnanjelic.simpletvstreamingapp.videoplayerexo.player.VideoPlayerExo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UiModule {

    @Provides
    fun providesVideoPlayer(): VideoPlayer = VideoPlayerExo()
}
