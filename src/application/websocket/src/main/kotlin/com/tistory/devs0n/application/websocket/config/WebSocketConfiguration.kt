package com.tistory.devs0n.application.websocket.config

import com.tistory.devs0n.application.websocket.ui.WebSocketSessionHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@EnableWebSocket
@Configuration
class WebSocketConfiguration(
    private val webSocketSessionHandler: WebSocketSessionHandler,
) : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry
            .addHandler(this.webSocketSessionHandler, "/ws")
            .setAllowedOrigins("*")
    }
}
