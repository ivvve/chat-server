dependencies {
    implementation(project(":domain:space"))

    // Web
    implementation("org.springframework.boot:spring-boot-starter-websocket")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
