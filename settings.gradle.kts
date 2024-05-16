pluginManagement {
    includeBuild("build-logic")
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

rootProject.name = "SmartphonesApp"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")

include(":core:common")
include(":core:design-system")
include(":core:ui")

include(":business:database")
include(":business:network")

include(":business:models:cache-models")
include(":business:models:remote-models")
include(":business:models:ui-models")
include(":business:models:domain-models")

include(":business:data:catalog-data")

include(":business:domain:catalog-domain")

include(":features:smartphone-details")
include(":features:smartphones")
include(":business:data:product-data")
include(":business:domain:product-domain")
include(":business:data:favorite-data")
include(":business:domain:favorite-domain")
