package com.adnanjelic.simpletvstreamingapp.shared.navigation.utils

import com.adnanjelic.simpletvstreamingapp.shared.navigation.NavigationConstants

fun String.addParameter(parameter: String) =
    "$this/${NavigationConstants.ParameterWrapper.format(parameter)}"

fun String.addParameterValue(parameter: String, value: String) =
    this.replace(NavigationConstants.ParameterWrapper.format(parameter), value)
