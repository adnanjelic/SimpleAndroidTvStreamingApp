pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "SimpleTvStreamingApp"

include(":app")
include(":theme")
include(":feature-home:ui")
include(":feature-home:presentation")
include(":architecture:presentation")
include(":architecture:domain")
include(":feature-home:domain")
