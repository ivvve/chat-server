dependencies {
    implementation(project(":domain:chat"))

    // Web
    implementation("org.springframework.boot:spring-boot-starter-websocket")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
