plugins {
    alias(libs.plugins.custom.module.network)
}

android {
    namespace = "com.mechta.network"
}

dependencies {
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.serialization.kotlinx.json)
}