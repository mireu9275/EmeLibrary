plugins {
    kotlin("jvm") version "1.9.23"
}

group = "kr.eme.plugin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk17")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.23")
    compileOnly("io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT")
    testImplementation(kotlin("test"))
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

tasks.jar {
    manifest {
        attributes["paperweight-mappings-namespace"] = "spigot"
    }
}
// if you have shadowJar configured
//tasks.shadowJar {
//    manifest {
//        attributes["paperweight-mappings-namespace"] = "spigot"
//    }
//}