package com.mechta.convention.library

import com.mechta.convention.utils.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

class LibraryJvmPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
            }
            configureKotlinJvm()
        }
    }
}
