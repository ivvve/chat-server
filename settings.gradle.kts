pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/release") }
        gradlePluginPortal()
    }
}
rootProject.name = "chat"

val modules: MutableList<Module> = mutableListOf()

fun module(name: String, path: String) {
    modules.add(Module(name, "${rootDir}/${path}"))
}

data class Module(
    val name: String,
    val path: String,
)

// application
module(name = ":application:api", path = "src/application/api")

// domain
module(name = ":domain:chat", path = "src/domain/chat")

modules.forEach {
    include(it.name)
    project(it.name).projectDir = file(it.path)
}
