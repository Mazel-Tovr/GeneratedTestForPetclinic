pluginManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        maven(url = "https://plugins.gradle.org/m2/")
        maven(url = "https://oss.jfrog.org/artifactory/oss-release-local")
    }
    plugins {
        id("com.epam.drill.agent.runner.autotest") version ("0.2.2")
        kotlin("jvm") version "1.4.21"
    }
}

rootProject.name = "GeneratedTestForPetclinic"

