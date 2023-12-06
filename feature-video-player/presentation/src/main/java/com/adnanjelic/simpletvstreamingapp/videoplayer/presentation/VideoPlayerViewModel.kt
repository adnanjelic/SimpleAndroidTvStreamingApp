package com.adnanjelic.simpletvstreamingapp.videoplayer.presentation

import androidx.lifecycle.SavedStateHandle
import com.adnanjelic.simpletvstreamingapp.architecture.domain.UseCaseExecutor
import com.adnanjelic.simpletvstreamingapp.architecture.presentation.viewmodel.BaseViewModel
import com.adnanjelic.simpletvstreamingapp.shared.navigation.NavigationConstants.MOVIE_ID_PARAMETER
import com.adnanjelic.simpletvstreamingapp.videoplayer.domain.usecase.GetVideoPlayerDataUseCase
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.mapper.VideoPlayerDomainToPresentationExceptionMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.mapper.VideoPlayerDomainToPresentationModelMapper
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerPresentationDestination
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerPresentationDestination.Back
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerPresentationNotification
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerViewState
import com.adnanjelic.simpletvstreamingapp.videoplayer.presentation.model.VideoPlayerViewState.Loaded
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoPlayerViewModel @Inject constructor(
    private val getVideoPlayerDataUseCase: GetVideoPlayerDataUseCase,
    private val videoPlayerMapper: VideoPlayerDomainToPresentationModelMapper,
    private val exceptionMapper: VideoPlayerDomainToPresentationExceptionMapper,
    savedStateHandle: SavedStateHandle,
    useCaseExecutor: UseCaseExecutor
) : BaseViewModel<VideoPlayerViewState, VideoPlayerPresentationNotification, VideoPlayerPresentationDestination>(
    useCaseExecutor
) {
    override val initialViewState = VideoPlayerViewState.Loading

    private val movieId: String = checkNotNull(savedStateHandle[MOVIE_ID_PARAMETER])

    init {
        loadData()
    }

    private fun loadData() {
        executeUseCase(
            useCase = getVideoPlayerDataUseCase,
            value = movieId,
            onResult = { updateViewState(Loaded(videoPlayerMapper.toPresentation(it))) },
            onException = { notify(exceptionMapper.toPresentation(it)) }
        )
    }

    fun onNavigateBackSelected() {
        navigate(Back)
    }
}
