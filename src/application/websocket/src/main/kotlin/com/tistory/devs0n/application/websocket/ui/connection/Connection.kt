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

    abstract fun send(message: String)

    companion object {
        protected const val TIMEOUT_THRESHOLD_SECONDS = 10
    }
}
