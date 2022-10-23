package com.tistory.devs0n.application.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChatApplication

fun main(args: Array<String>) {
    runApplication<ChatApplication>(args = args)
}
