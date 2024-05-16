plugins {
    alias(libs.plugins.custom.module.model)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.mechta.cache_models"
}

dependencies {

    implementation(projects.business.models.remoteModels)
    implementation(projects.business.models.uiModels)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.room.runtime)
}