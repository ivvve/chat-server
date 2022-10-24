package com.tistory.devs0n.domain.chat.core.room.domain

interface ChatRoomRepository {
    fun save(chatRoom: ChatRoom): ChatRoom
}
