package com.mechta.convention.module

import com.android.build.gradle.LibraryExtension
import com.mechta.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class ModuleFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            pluginManager.apply {
                apply("custom.library")
                apply("custom.library.hilt")
                apply("custom.library.compose")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }

            dependencies {
                add("implementation", project(":core:common"))

                add("implementation", project(":core:design-system"))
                add("implementation", project(":core:ui"))

                add("implementation", project(":business:models:ui-models"))

                //hilt viewmodel
                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())

                //navigation
                add("implementation", libs.findLibrary("androidx.navigation.compose").get())

                //collectAsStateWithLifecycle
                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())

                //test
                add("implementation", libs.findLibrary("junit4").get())
                add("implementation", libs.findLibrary("androidx.test.ext.junit").get())
            }
        }
    }
}
