package com.tistory.devs0n.application.websocket.ui

import com.tistory.devs0n.application.websocket.common.SystemClock
import com.tistory.devs0n.application.websocket.ui.connection.ConnectionPool
import com.tistory.devs0n.application.websocket.ui.connection.WebSocketSessionConnection
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

@Component
class WebSocketConnectionHandler(
    private val systemClock: SystemClock,
    private val connectionPool: ConnectionPool,
) : TextWebSocketHandler() {

    /**
     * @see [org.springframework.web.socket.WebSocketHandler.afterConnectionEstablished]
     */
    override fun afterConnectionEstablished(session: WebSocketSession) {
        val now = systemClock.now()
        val connection = WebSocketSessionConnection(session = session, now = now)
        session.setConnection(connection)
        this.connectionPool.add(connection)
    }

    /**
     * @see [org.springframework.web.socket.WebSocketHandler.afterConnectionClosed]
     */
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        val connection = session.getConnection()
        this.connectionPool.remove(connection)
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
