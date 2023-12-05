plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply {
    from("${project.rootDir}/gradle/android-lib-defaults.build.gradle")
}

android {
    namespace = "com.adnanjelic.simpletvstreamingapp.architecture.ui"
}

dependencies {
    implementation(projects.architecture.presentation)
    implementation(projects.shared.navigation)
}
