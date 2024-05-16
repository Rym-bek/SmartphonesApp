package com.mechta.convention.module

import com.android.build.gradle.LibraryExtension
import com.mechta.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class ModuleDataPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            pluginManager.apply {
                apply("custom.library")
                apply("custom.library.hilt")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }

            dependencies {
                add("implementation", project(":core:common"))

                add("implementation", project(":business:models:remote-models"))
                add("implementation", project(":business:models:cache-models"))
                add("implementation", project(":business:models:domain-models"))

                add("implementation", project(":business:database"))

                add("implementation", project(":business:network"))

                //test
                add("implementation", libs.findLibrary("junit4").get())
                add("implementation", libs.findLibrary("androidx.test.ext.junit").get())
            }
        }
    }
}