dependencies {
    implementation(project(":domain:chat"))

    // Web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Util
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Documentation
    implementation("org.springdoc:springdoc-openapi-ui:1.6.12")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.12")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
