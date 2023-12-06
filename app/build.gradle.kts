plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
}

apply {
    from("${project.rootDir}/gradle/android-lib-defaults.build.gradle")
}

android {
    namespace = "com.adnanjelic.simpletvstreamingapp"

    defaultConfig {
        applicationId = "com.adnanjelic.simpletvstreamingapp"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.extension.get()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Modules
    implementation(projects.theme)
    implementation(projects.architecture.domain)
    implementation(projects.shared.navigation)
    implementation(projects.shared.storage)
    implementation(projects.featureHome.datasource)
    implementation(projects.featureHome.data)
    implementation(projects.featureHome.domain)
    implementation(projects.featureHome.presentation)
    implementation(projects.featureHome.ui)
    implementation(projects.featureMovieDetails.ui)
    implementation(projects.featureMovieDetails.presentation)
    implementation(projects.featureMovieDetails.domain)
    implementation(projects.featureMovieDetails.data)
    implementation(projects.featureMovieDetails.datasource)
    implementation(projects.featureVideoPlayer.ui)
    implementation(projects.featureVideoPlayer.presentation)
    implementation(projects.featureVideoPlayer.domain)
    implementation(projects.featureVideoPlayer.data)
    implementation(projects.featureVideoPlayer.datasource)

    // AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.collection.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // DI
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    // Compose
    implementation(libs.compose.activity)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.androidx.tv.foundation)
    implementation(libs.androidx.tv.material)

    // Storage
    implementation(libs.androidx.room.ktx)
}
