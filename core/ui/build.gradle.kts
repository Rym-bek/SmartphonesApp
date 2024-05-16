plugins {
    alias(libs.plugins.custom.library)
    alias(libs.plugins.custom.library.compose)
}

android {
    namespace = "com.mechta.ui"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.designSystem)

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)

    //paging3
    implementation(libs.androidx.paging.compose)

    //test
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext.junit)
}