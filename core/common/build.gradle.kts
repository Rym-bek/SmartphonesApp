plugins {
    alias(libs.plugins.custom.library)
}

android {
    namespace = "com.mechta.common"
}

dependencies {
    //viewModel support
    implementation(libs.androidx.lifecycle.viewmodelKtx)

    //test
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext.junit)
}