pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven (
            url ="https://github.com/jitsi/jitsi-maven-repository/raw/master/releases"
        )
        maven (
            url ="https://maven.google.com"
        )
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven (
            url ="https://github.com/jitsi/jitsi-maven-repository/raw/master/releases"
        )
        maven (
            url ="https://maven.google.com"
        )
        google()
        mavenCentral()
    }
}

rootProject.name = "VedioCalling Jitsi Meet"
include(":app")
