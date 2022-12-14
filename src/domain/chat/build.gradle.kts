import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    // DB
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.redisson:redisson-spring-boot-starter:3.17.7")

    // Util
    implementation("com.github.f4b6a3:ksuid-creator:4.0.2")
}
