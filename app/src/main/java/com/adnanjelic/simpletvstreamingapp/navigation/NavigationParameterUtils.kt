package com.adnanjelic.simpletvstreamingapp.navigation

internal fun String.addParameter(parameter: String) =
    "$this/${NavigationConstants.ParameterWrapper.format(parameter)}"

internal fun String.addParameterValue(parameter: String, value: String) =
    this.replace(NavigationConstants.ParameterWrapper.format(parameter), value)
