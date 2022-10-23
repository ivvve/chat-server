import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("org.springframework.experimental.aot") version "0.12.1"
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
}

allprojects {
    group = "com.tistory.devs0n"
    version = "0.0.1-SNAPSHOT"

    repositories {
        maven { url = uri("https://repo.spring.io/release") }
        mavenCentral()
    }
}

java.sourceCompatibility = JavaVersion.VERSION_17

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.springframework.experimental.aot")
        plugin("io.gitlab.arturbosch.detekt")
    }

    dependencies {
        // Kotlin
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // Logging
        implementation("io.github.microutils:kotlin-logging-jvm:3.0.2")

        // Lint
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.21.0")
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
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
}

//extra["testcontainersVersion"] = "1.17.4"
//
//dependencies {
//    //Kotlin
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//
//    // Operation
//    developmentOnly("org.springframework.boot:spring-boot-devtools")
//    implementation("org.springframework.boot:spring-boot-starter-actuator")
//
//    // Web
//    implementation("org.springframework.boot:spring-boot-starter-websocket")
//
//    // Util
//    implementation("org.springframework.boot:spring-boot-starter-validation")
//    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
//
//    // Testing
//    testImplementation("org.testcontainers:junit-jupiter")
//    testImplementation("org.testcontainers:mongodb")
//}

//dependencyManagement {
//    imports {
//        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
//    }
//}
