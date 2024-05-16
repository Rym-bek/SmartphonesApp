plugins {
    alias(libs.plugins.custom.module.data)
}

android {
    namespace = "com.mechta.catalog_data"
}

dependencies {
    implementation(libs.androidx.paging.common)

    //room
    implementation(libs.androidx.room.ktx)
}