plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ktlint)
}

apply {
    from("${project.rootDir}/gradle/android-lib-defaults.build.gradle")
}

android {
    namespace = "com.adnanjelic.simpletvstreamingapp.moviedetails.ui"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.extension.get()
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Modules
    implementation(projects.theme)
    implementation(projects.architecture.ui)
    implementation(projects.architecture.presentation)

    // DI
    implementation(libs.hilt.android)

    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)

    // Compose
    implementation(libs.compose.activity)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.androidx.tv.foundation)
    implementation(libs.androidx.tv.material)

    // Coil
    implementation(libs.coil.compose)
}
