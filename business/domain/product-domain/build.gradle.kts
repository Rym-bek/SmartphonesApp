plugins {
    alias(libs.plugins.custom.module.domain)
}

android {
    namespace = "com.mechta.product_domain"
}

dependencies {
    implementation(projects.business.data.productData)
    implementation(projects.business.data.favoriteData)
}