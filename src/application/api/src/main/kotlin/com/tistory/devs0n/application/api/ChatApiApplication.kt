package com.tistory.devs0n.application.api

import com.tistory.devs0n.domain.chat.EnableDomainChatModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableDomainChatModule
@SpringBootApplication
class ChatApiApplication

fun main(args: Array<String>) {
    runApplication<ChatApiApplication>(args = args)
}
