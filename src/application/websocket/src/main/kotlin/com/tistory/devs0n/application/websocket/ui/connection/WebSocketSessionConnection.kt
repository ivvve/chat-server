package com.tistory.devs0n.application.websocket.ui.connection

import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import java.time.LocalDateTime

class WebSocketSessionConnection(
    private val session: WebSocketSession,
    now: LocalDateTime
) : Connection(now = now) {
    override fun send(message: String) {
        this.session.sendMessage(TextMessage(message))
    }
}
