package com.javajedi.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File


/**
 *
 * This task can be written in Kotlin
 * as a class implementing DefaultTask in the following way
 *
 * task("makeRelease") {
 *     inputs.property("release", project.ext.get("release"))
 *     outputs.file("$rootDir/service/script.gradle.kts")
 *     doLast {
 *         println("Release in progress")
 *     }
 * }
 *
 * */
abstract class ReleaseTask(

) : DefaultTask() {

    @Input
    var release: Boolean = false

    @OutputFile
    lateinit var file: File

    @TaskAction
    fun performAction() {
//        this.group = "build"
        println("Release in action")
    }

}