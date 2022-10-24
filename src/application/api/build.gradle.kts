import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

dependencies {
    implementation(project(":domain:chat"))

    // Web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Documentation
    implementation("org.springdoc:springdoc-openapi-ui:1.6.12")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.12")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<BootBuildImage> {
    builder = "paketobuildpacks/builder:tiny"
    environment = mapOf("BP_NATIVE_IMAGE" to "true")
}
