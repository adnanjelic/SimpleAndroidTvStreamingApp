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
include(":architecture:ui")
include(":architecture:presentation")
include(":architecture:domain")
include(":architecture:data")
include(":feature-home:ui")
include(":feature-home:presentation")
include(":feature-home:domain")
include(":feature-home:data")
include(":feature-home:datasource")
