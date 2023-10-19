plugins {
    id("java")
    id("war")
}

group = "com.baggio"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":service"))
    implementation(project(":common:util"))
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

val war: War = tasks.named<War>("war") {
    archiveFileName = "web-service.war"
}.get()

val deployTomcatTask: Task = task("deployTomcat", type = Copy::class) {
    group = "build"
    println("Initializing a new task - Deploying war archive to Tomcat")
    from(war.archiveFile)
    into("/Users/baggio/Applications/apache-tomcat-9.0.43/webapps")
}

deployTomcatTask.dependsOn(war)

tasks.first { it.name == "assemble" }.dependsOn(deployTomcatTask)

tasks.test {
    useJUnitPlatform()
    useJUnitPlatform()
}
