plugins {
    id("java")
}

apply {
    plugin(CustomPlugin::class)
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-webmvc:6.0.13")
}

/***
 *
 *       Configuration 1 - Fat jar

 *      We unzip all the dependent jar files and place compiled files in the same folder as our source code
 *
 *      val runtimeClassPathFiles: Set<File> = configurations.named("runtimeClasspath").get().files
 *      runtimeClassPathFiles
 *          .also { println("Runtime files size: ${it.size}") }
 *          .forEach { println("Name: $it") }
 *      tasks.named<Jar>("jar") {
 *          manifest {
 *              attributes(mapOf(
 *                  "Main-Class" to "com.baggio.HelloWorld"
 *              ))
 *          }
 *          duplicatesStrategy = DuplicatesStrategy.EXCLUDE
 *          from(runtimeClassPathFiles.map { zipTree(it) })
 *      }
 *
 * */


val runtimeClassPathFiles: Set<File> = configurations.named("runtimeClasspath").get().files


runtimeClassPathFiles
    .also { println("Runtime files size: ${it.size}") }
    .forEach { println("Name: ${it.name}") }

tasks.named<Jar>("jar") {
    manifest {
        attributes(mapOf(
            "Main-Class" to "com.baggio.HelloWorld",
            "Class-Path" to runtimeClassPathFiles.map { "lib/${it.name}" }.joinToString(separator = " ") { it }
        ))
    }
}

val copyAllDependencies = task("copyAllDependencies", type = Copy::class) {
    from(runtimeClassPathFiles)
    into("${project.layout.projectDirectory}/build/libs/lib")
}

tasks.named<Jar>("jar").get().dependsOn(copyAllDependencies)


class CustomPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        addTask(project)
    }

    private fun addTask(project: Project) {
        val taskMap = mapOf("description" to "custom plugin task", "group" to "custom plugin group")
        project.task("customPlugin") {
            println("This is custom plugin task. Properties: $taskMap")
            doFirst {
                println("Custom plugin executing")
            }
            doLast {
                println("Execution finishing")
            }
        }
    }

}

sourceSets {
    main {
        java {
            srcDirs("${layout.buildDirectory}/generated-sources/shit")
        }
    }
    test {

    }
}

