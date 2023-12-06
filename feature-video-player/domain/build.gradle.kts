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
    namespace = "com.adnanjelic.simpletvstreamingapp.videoplayer.domain"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.android)
    implementation(projects.architecture.domain)
    ksp(libs.hilt.android.compiler)
}
