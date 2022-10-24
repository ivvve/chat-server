package com.tistory.devs0n.application.api.common

import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class Timer {
    fun now(): LocalDateTime {
        return LocalDateTime.now()
    }
}
