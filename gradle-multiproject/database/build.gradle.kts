plugins {
    id("java-library")
}

group = "com.baggio"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":common:core"))
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}