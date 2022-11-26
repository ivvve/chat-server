package com.tistory.devs0n.application.websocket.ui.connection

import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.concurrent.ConcurrentHashMap

@Component
class ConnectionPool {
    private val connections: MutableSet<Connection> = ConcurrentHashMap.newKeySet()

    fun add(connection: Connection) {
        this.connections.add(connection)
    }

    fun remove(connection: Connection) {
        this.connections.remove(connection)
    }

    fun closeAndRemoveTimeoutConnections(now: LocalDateTime) {
        val timeoutConnections = this.connections.filter { it.isTimeout(now) }.toSet()
        timeoutConnections.forEach { it.close(ConnectionCloseStatus.SESSION_NOT_RELIABLE) }
        this.connections.removeAll(timeoutConnections)
    }
}
