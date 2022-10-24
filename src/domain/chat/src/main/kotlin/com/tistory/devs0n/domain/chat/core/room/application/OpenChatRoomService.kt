package com.tistory.devs0n.domain.chat.core.room.application

import com.tistory.devs0n.domain.chat.core.room.domain.ChatRoom
import com.tistory.devs0n.domain.chat.core.room.domain.ChatRoomIdGenerator
import com.tistory.devs0n.domain.chat.core.room.domain.ChatRoomRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
@Transactional
class OpenChatRoomService(
    private val chatRoomRepository: ChatRoomRepository,
) {
    fun open(hostUserId: String, roomTitle: String, openDateTime: LocalDateTime): ChatRoom {
        val chatRoom = ChatRoom(
            id = ChatRoomIdGenerator.generate(),
            title = roomTitle,
            hostUserId = hostUserId,
            createDateTime = openDateTime,
        )
        return this.chatRoomRepository.save(chatRoom)
    }
}
