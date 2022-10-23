package com.tistory.devs0n.application.api

import com.tistory.devs0n.domain.chat.EnableDomainChatModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableDomainChatModule
@SpringBootApplication
class ChatApplication

fun main(args: Array<String>) {
    runApplication<ChatApplication>(args = args)
}
