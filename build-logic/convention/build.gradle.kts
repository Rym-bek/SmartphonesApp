import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.mechta.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("application") {
            id = "custom.application"
            implementationClass = "com.mechta.convention.application.ApplicationPlugin"
        }

        register("applicationCompose") {
            id = "custom.application.compose"
            implementationClass = "com.mechta.convention.application.ApplicationComposePlugin"
        }

        register("library") {
            id = "custom.library"
            implementationClass = "com.mechta.convention.library.LibraryPlugin"
        }

        register("libraryCompose") {
            id = "custom.library.compose"
            implementationClass = "com.mechta.convention.library.LibraryComposePlugin"
        }

        register("libraryRoom") {
            id = "custom.library.room"
            implementationClass = "com.mechta.convention.library.LibraryRoomPlugin"
        }

        register("libraryHilt") {
            id = "custom.library.hilt"
            implementationClass = "com.mechta.convention.library.LibraryHiltPlugin"
        }

        register("libraryJvm") {
            id = "custom.library.jvm"
            implementationClass = "com.mechta.convention.library.LibraryJvmPlugin"
        }

        register("moduleFeature") {
            id = "custom.module.feature"
            implementationClass = "com.mechta.convention.module.ModuleFeaturePlugin"
        }

        register("moduleModel") {
            id = "custom.module.model"
            implementationClass = "com.mechta.convention.module.ModuleModelPlugin"
        }

        register("moduleDatabase") {
            id = "custom.module.database"
            implementationClass = "com.mechta.convention.module.ModuleDatabasePlugin"
        }

        register("moduleNetwork") {
            id = "custom.module.network"
            implementationClass = "com.mechta.convention.module.ModuleNetworkPlugin"
        }

        register("moduleData") {
            id = "custom.module.data"
            implementationClass = "com.mechta.convention.module.ModuleDataPlugin"
        }

        register("moduleDomain") {
            id = "custom.module.domain"
            implementationClass = "com.mechta.convention.module.ModuleDomainPlugin"
        }
    }
}
