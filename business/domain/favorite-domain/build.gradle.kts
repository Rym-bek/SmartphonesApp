plugins {
    alias(libs.plugins.custom.module.domain)
}

android {
    namespace = "com.mechta.favorite_domain"
}

dependencies {
    implementation(projects.business.data.favoriteData)
}