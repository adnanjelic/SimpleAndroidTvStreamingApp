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
include(":navigation")
include(":architecture:ui")
include(":architecture:presentation")
include(":architecture:domain")
include(":architecture:data")
include(":feature-home:ui")
include(":feature-home:presentation")
include(":feature-home:domain")
include(":feature-home:data")
include(":feature-home:datasource")
include(":feature-movie-details:ui")
include(":feature-movie-details:presentation")
include(":feature-movie-details:domain")
include(":feature-movie-details:data")
include(":feature-movie-details:datasource")
include(":feature-video-player:ui")
include(":feature-video-player:presentation")
include(":feature-video-player:domain")
include(":feature-video-player:data")
include(":feature-video-player:datasource")
include(":shared:storage")
include(":shared:ui")
