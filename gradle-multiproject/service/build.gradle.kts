import com.javajedi.task.ReleaseTask

plugins {
    id("java-library")
    id("custom-javajedi")
}

// Applying plugin via Plugin class name,
// But we can do this using id("")
//apply {
//    plugin(CustomPlugin::class)
//}

group = "com.baggio"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":database"))
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<ReleaseTask>("releaseTask")

tasks.named<ReleaseTask>("releaseTask") {
    val release = properties["release"].toString().toBoolean()
    println("Release here: $release")
    this.release = release
    this.file = File("$rootDir/service/script.gradle.kts")
}
