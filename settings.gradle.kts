
// Allow project repositories to override settings repositories
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google() // Add Google's Maven repository if necessary
        // Add other repositories here if needed
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "SmartAttendance"
include(":app")
