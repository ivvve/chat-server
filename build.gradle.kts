import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("org.springframework.experimental.aot") version "0.12.1"
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
}

group = "com.tistory.devs0n"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    maven { url = uri("https://repo.spring.io/release") }
    mavenCentral()
}

extra["testcontainersVersion"] = "1.17.4"

dependencies {
    //Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Operation
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Web
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-websocket")

    // DB
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.redisson:redisson-spring-boot-starter:3.17.7")

    // Util
    implementation("org.springframework.boot:spring-boot-starter-validation")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // Logging
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.2")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mongodb")

    // Lint
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.21.0")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<BootBuildImage> {
    builder = "paketobuildpacks/builder:tiny"
    environment = mapOf("BP_NATIVE_IMAGE" to "true")
}

// Kotlin Lint - Detekt
tasks.withType<Detekt>().configureEach {
    jvmTarget = "17"

    reports {
        html.required.set(true) // observe findings in your browser with structure and code snippets
        xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
        txt.required.set(false) // similar to the console output, contains issue signature to manually edit baseline files
        sarif.required.set(false) // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with Github Code Scanning
        md.required.set(false) // simple Markdown format
    }
}
tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = "17"
}
