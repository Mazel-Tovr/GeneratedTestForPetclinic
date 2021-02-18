plugins {
    java
    kotlin("jvm")
    id("com.epam.drill.agent.runner.autotest")
}

group = "com.epam"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

val jUnitVersion = "5.6.2"
val restAssuredVersion = "4.0.0"
val selenideVersion = "5.13.0"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.squareup:kotlinpoet:1.7.2")
    implementation("io.rest-assured:rest-assured:$restAssuredVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")
    testImplementation("org.seleniumhq.selenium:selenium-java:3.141.59")
    testImplementation("io.github.bonigarcia:webdrivermanager:3.8.1")
}
drill {
    version = "0.14.8"
    adminHost = "localhost"
    // groupId = "pet-mcr" //if we are testion microservice uncomment this and write groupId
    agentId = "Petclinic"
    adminPort = 8090
    logFile = File("agent log")
    logLevel = com.epam.drill.agent.runner.LogLevels.DEBUG
}

tasks.withType<Test> {
    useJUnitPlatform()
}
