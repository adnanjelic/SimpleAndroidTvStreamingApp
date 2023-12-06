package com.adnanjelic.simpletvstreamingapp.featurehome.ui.di

import com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper.CategoryPresentationToUiModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper.HomeInfoPresentationDestinationToNavigationDestinationModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper.HomeNotificationPresentationToUiModelMapper
import com.adnanjelic.simpletvstreamingapp.featurehome.ui.mapper.MoviePresentationToUiModelMapper
import javax.inject.Inject

class HomeDependencies @Inject constructor(
    val movieMapper: MoviePresentationToUiModelMapper,
    val categoriesMapper: CategoryPresentationToUiModelMapper,
    val destinationMapper: HomeInfoPresentationDestinationToNavigationDestinationModelMapper,
    val notificationMapper: HomeNotificationPresentationToUiModelMapper
)
