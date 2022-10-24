package com.tistory.devs0n.domain.chat.core.room.infrastructure

import com.tistory.devs0n.domain.chat.core.room.domain.ChatRoom
import com.tistory.devs0n.domain.chat.core.room.domain.ChatRoomRepository
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
class MongoDBChatRoomRepository(
    private val repository: InnerMongoDBChatRoomRepository,
) : ChatRoomRepository {
    override fun save(chatRoom: ChatRoom): ChatRoom {
        return this.repository.save(chatRoom)
    }
}

interface InnerMongoDBChatRoomRepository : MongoRepository<ChatRoom, String>
