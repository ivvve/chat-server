import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

dependencies {
    implementation(project(":domain:chat"))

    // Web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<BootBuildImage> {
    builder = "paketobuildpacks/builder:tiny"
    environment = mapOf("BP_NATIVE_IMAGE" to "true")
}
