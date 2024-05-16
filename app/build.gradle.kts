import com.mechta.convention.utils.AppBuildType

plugins {
    alias(libs.plugins.custom.application)
    alias(libs.plugins.custom.application.compose)
    alias(libs.plugins.custom.library.hilt)
}

android {
    namespace = "com.mechta.smartphonesapp"
    defaultConfig {
        applicationId = "com.mechta.smartphonesapp"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        resourceConfigurations += setOf("kk", "ru", "en")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            applicationIdSuffix = AppBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            applicationIdSuffix = AppBuildType.DEBUG.applicationIdSuffix
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.core.designSystem)
    implementation(projects.features.smartphones)
    implementation(projects.features.smartphoneDetails)

    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    //coil
    implementation(libs.coil)

    //navigation
    implementation(libs.androidx.navigation.compose)

    //test
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext.junit)
}