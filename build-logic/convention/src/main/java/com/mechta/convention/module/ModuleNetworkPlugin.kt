package com.mechta.convention.module

import com.mechta.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


class ModuleNetworkPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("custom.library")
                apply("custom.library.hilt")

                apply("kotlinx-serialization")
            }

            dependencies {
                add("implementation", project(":core:common"))

                add("implementation", project(":business:models:remote-models"))
                
                add("implementation", libs.findLibrary("ktor-client-core").get())
                add("implementation", libs.findLibrary("ktor-client-resources").get())

                //test
                add("implementation", libs.findLibrary("junit4").get())
                add("implementation", libs.findLibrary("androidx.test.ext.junit").get())
            }
        }
    }
}