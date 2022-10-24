package com.tistory.devs0n.application.api.ui.room.dto

import com.tistory.devs0n.domain.chat.core.room.domain.ChatRoom

data class RoomResponse(
    val id: String,
    val title: String,
    val hostUserId: String,
) {
    companion object {
        fun of(chatRoom: ChatRoom): RoomResponse {
            return RoomResponse(
                id = chatRoom.id,
                title = chatRoom.title,
                hostUserId = chatRoom.hostUserId,
            )
        }
    }
}
