package com.tistory.devs0n.domain.chat.core.room.domain

import com.github.f4b6a3.ksuid.KsuidCreator

object ChatRoomIdGenerator {
    fun generate(): String {
        return KsuidCreator.getSubsecondKsuid().toString()
    }
}
