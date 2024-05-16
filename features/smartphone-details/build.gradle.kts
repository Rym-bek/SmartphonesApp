plugins {
    alias(libs.plugins.custom.module.feature)
}

android {
    namespace = "com.mechta.smartphone_details"
}

dependencies {
    implementation(projects.business.domain.productDomain)
    implementation(projects.business.domain.favoriteDomain)
}