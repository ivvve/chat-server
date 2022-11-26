package com.tistory.devs0n.application.websocket.config

import com.tistory.devs0n.application.websocket.common.SystemClock
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SystemTimeConfiguration {
    @Bean
    fun systemClock(): SystemClock {
        return SystemClock()
    }
}
