import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName

plugins {
    kotlin("jvm") version "1.9.23"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "kr.eme.plugin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

//tasks.jar {
//    archiveFileName = "${project.name}-${project.version}.jar"
//    destinationDirectory = file("D:\\minecraft\\1. 버킷 관련\\1.20.2 paper_dev2\\plugins")
//    manifest {
//        attributes["main-class"] = "kr.eme.plugin.emeLibrary.EmeLibrary"
//    }
//}

tasks.shadowJar {
    archiveFileName = "${project.name}-${project.version}.jar"
    destinationDirectory = file("D:\\minecraft\\1. 버킷 관련\\1.20.2 paper_dev2\\plugins")
    manifest {
        attributes["main-class"] = "kr.eme.plugin.emeLibrary.EmeLibrary"
    }
}