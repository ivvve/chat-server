package com.tistory.devs0n.application.websocket

import com.tistory.devs0n.domain.chat.EnableDomainChatModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableDomainChatModule
@SpringBootApplication
class ChatWebSocketApplication

fun main(args: Array<String>) {
    runApplication<ChatWebSocketApplication>(args = args)
}
