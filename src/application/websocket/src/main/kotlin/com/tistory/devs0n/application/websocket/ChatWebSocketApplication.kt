package com.tistory.devs0n.application.websocket

import com.tistory.devs0n.domain.space.EnableDomainSpaceModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableDomainSpaceModule
@SpringBootApplication
class ChatWebSocketApplication

fun main(args: Array<String>) {
    runApplication<ChatWebSocketApplication>(args = args)
}
