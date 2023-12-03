plugins {
    id("java-library")
    alias(libs.plugins.ktlint)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
