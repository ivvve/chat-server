package com.tistory.devs0n.application.websocket.ui.connection

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class ConnectionPool {
    private val connections: MutableSet<Connection> = ConcurrentHashMap.newKeySet()

    fun getConnections(): Set<Connection> {
        return this.connections.toSet()
    }

    fun add(connection: Connection) {
        this.connections.add(connection)
    }

    fun remove(connection: Connection) {
        this.connections.remove(connection)
    }
}
