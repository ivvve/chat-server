package com.tistory.devs0n.application.websocket.common

import java.time.LocalDateTime

class SystemClock {
    fun now(): LocalDateTime {
        return LocalDateTime.now()
    }
}
