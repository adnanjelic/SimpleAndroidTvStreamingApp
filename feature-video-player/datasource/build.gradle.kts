plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
}

apply {
    from("${project.rootDir}/gradle/android-lib-defaults.build.gradle")
}

android {
    namespace = "com.adnanjelic.simpletvstreamingapp.videoplayer.datasource"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    implementation(projects.featureVideoPlayer.data)
    implementation(projects.architecture.data)
    implementation(projects.shared.storage)

    testImplementation(libs.test.junit)
    testImplementation(libs.test.mockito.kotlin)
}
