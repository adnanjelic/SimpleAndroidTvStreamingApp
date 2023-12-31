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
    namespace = "com.adnanjelic.simpletvstreamingapp.featurehome.datasource"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    implementation(projects.featureHome.data)
    implementation(projects.architecture.data)
    implementation(projects.shared.storage)

    testImplementation(libs.test.junit)
    testImplementation(libs.test.mockito.kotlin)
}
