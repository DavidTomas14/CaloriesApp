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
include(":core-ui")
include(":features")
include(":features:onboarding")
include(":features:onboarding:presentation")
include(":features:onboarding:domain")
include(":features:tracker")
include(":features:tracker:data")
include(":features:tracker:domain")
include(":features:tracker:presentation")
