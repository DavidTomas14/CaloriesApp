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

rootProject.name = "CaloriesApp"
include(":app")
include(":core")
include(":onboarding")
include(":onboarding:presentation")
include(":onboarding:domain")
include(":tracker")
include(":tracker:data")
include(":tracker:domain")
include(":tracker:presentation")
