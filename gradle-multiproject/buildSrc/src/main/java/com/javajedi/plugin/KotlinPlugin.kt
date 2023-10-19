package com.javajedi.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.task("custom-plugin") { it ->
            it.group = "build"
            println("Initialising new custom plugin task")
            it.doFirst {
                println("Executing custom plugin task with name: ${it.name}")
            }
        }
    }

}