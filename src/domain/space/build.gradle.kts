import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    implementation(project(":system-support:spring"))

    // Util
    implementation("com.github.f4b6a3:ksuid-creator:4.0.2")
}
