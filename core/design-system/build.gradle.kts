plugins {
    alias(libs.plugins.custom.library)
    alias(libs.plugins.custom.library.compose)
}

android {
    namespace = "com.mechta.design_system"
}

dependencies {
    implementation(projects.core.common)

    //coil
    implementation(libs.coil.compose)

    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)

    //test
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext.junit)
}