package com.tistory.devs0n.application.websocket.ui.connection

import java.time.Duration
import java.time.LocalDateTime

abstract class Connection(
    now: LocalDateTime,
) {
    protected var latestPongAt: LocalDateTime = now

    fun isTimeout(now: LocalDateTime): Boolean {
        val latestPongDuration = Duration.between(this.latestPongAt, now)
        return TIMEOUT_THRESHOLD_SECONDS < latestPongDuration.seconds
    }

    fun onPong(now: LocalDateTime) {
        this.latestPongAt = now
    }

    abstract fun send(message: String)

    abstract fun close(status: ConnectionCloseStatus)

    companion object {
        protected const val TIMEOUT_THRESHOLD_SECONDS = 5
    }
}
