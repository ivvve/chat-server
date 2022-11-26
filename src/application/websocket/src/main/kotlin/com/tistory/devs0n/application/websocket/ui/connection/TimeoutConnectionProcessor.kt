package com.tistory.devs0n.application.websocket.ui.connection

import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TimeoutConnectionProcessor(
    private val connectionPool: ConnectionPool,
) {
    fun closeTimeoutConnections(now: LocalDateTime) {
        val timeoutConnections = this.getTimeoutConnections(now)
        logger.info { "Process timeout connections - # of timeout connections: ${timeoutConnections.size} " }
        timeoutConnections.forEach { it.close(ConnectionCloseStatus.SESSION_NOT_RELIABLE) }
    }

    private fun getTimeoutConnections(now: LocalDateTime): Set<Connection> {
        val connections = this.connectionPool.getConnections()
        return connections.filter { it.isTimeout(now) }.toSet()
    }

    companion object {
        private val logger = KotlinLogging.logger { }
    }
}
