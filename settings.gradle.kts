pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Clean Feature Example"
include(":app")
include(":feature:product-api")
include(":feature:product")
include(":navigation")
include(":common-koin")
include(":feature:authorization-api")
include(":feature:authorization")
include(":feature:history-api")
include(":feature:history")
include(":feature:profile-api")
include(":feature:profile")
