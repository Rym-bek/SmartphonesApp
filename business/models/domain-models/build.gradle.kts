plugins {
    alias(libs.plugins.custom.module.model)
}

android {
    namespace = "com.mechta.domain_models"
}

dependencies {
    implementation(projects.business.models.cacheModels)
    implementation(projects.business.models.remoteModels)
    implementation(projects.business.models.uiModels)
}