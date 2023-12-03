plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ktlint)
}

apply {
    from("${project.rootDir}/gradle/android-lib-defaults.build.gradle")
}

android {
    namespace = "com.adnanjelic.theme"

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

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
}
