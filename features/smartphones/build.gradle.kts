plugins {
    alias(libs.plugins.custom.module.feature)
}

android {
    namespace = "com.mechta.smartphones"
}

dependencies {
    implementation(projects.business.domain.catalogDomain)
    implementation(projects.business.domain.favoriteDomain)

    implementation(libs.androidx.paging.compose)
}