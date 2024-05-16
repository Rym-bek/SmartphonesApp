plugins {
    alias(libs.plugins.custom.module.model)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.mechta.remote_models"
}

dependencies {
    implementation(projects.core.common)

    implementation(projects.business.models.uiModels)

    implementation(libs.kotlinx.serialization.json)
}