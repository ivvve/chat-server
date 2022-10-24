package com.tistory.devs0n.domain.chat.core.room.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType
import java.time.LocalDateTime

@Document(collection = "rooms")
class ChatRoom(
    id: String,
    title: String,
    hostUserId: String,
    createDateTime: LocalDateTime,
) {
    @Id
    @Field("_id", targetType = FieldType.STRING)
    val id: String = id

    @Field("title", targetType = FieldType.STRING)
    val title: String = title

    @Field("host_user_id", targetType = FieldType.STRING)
    val hostUserId: String = hostUserId

    @Field("created_at", targetType = FieldType.DATE_TIME)
    @CreatedDate
    var createdAt: LocalDateTime = createDateTime
        private set

    @Field("updated_at", targetType = FieldType.DATE_TIME)
    @LastModifiedDate
    var updatedAt: LocalDateTime = createDateTime
        private set
}
