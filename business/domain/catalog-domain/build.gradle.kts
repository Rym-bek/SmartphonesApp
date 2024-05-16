plugins {
    alias(libs.plugins.custom.module.domain)
}

android {
    namespace = "com.mechta.catalog_domain"
}

dependencies {
    implementation(projects.business.data.catalogData)
    implementation(projects.business.data.favoriteData)

    implementation(libs.androidx.paging.common)
}