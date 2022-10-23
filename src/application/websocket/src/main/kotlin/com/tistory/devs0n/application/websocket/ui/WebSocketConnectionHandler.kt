package com.tistory.devs0n.application.websocket.ui

import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

@Component
class WebSocketConnectionHandler : TextWebSocketHandler() {
    /**
     * @see [org.springframework.web.socket.WebSocketHandler.afterConnectionEstablished]
     */
    override fun afterConnectionEstablished(session: WebSocketSession) {
        super.afterConnectionEstablished(session)
    }

    /**
     * @see [org.springframework.web.socket.WebSocketHandler.afterConnectionClosed]
     */
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        super.afterConnectionClosed(session, status)
    }

    /**
     * @see [org.springframework.web.socket.WebSocketHandler.handleMessage]
     */
    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        super.handleTextMessage(session, message)
    }

    /**
     * @see [org.springframework.web.socket.WebSocketHandler.handleTransportError]
     */
    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        super.handleTransportError(session, exception)
    }
}
