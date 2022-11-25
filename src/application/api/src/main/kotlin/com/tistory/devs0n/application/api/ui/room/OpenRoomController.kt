package com.tistory.devs0n.application.api.ui.room

import com.tistory.devs0n.application.api.common.Timer
import com.tistory.devs0n.application.api.ui.room.dto.OpenRoomRequest
import com.tistory.devs0n.application.api.ui.room.dto.RoomResponse
import com.tistory.devs0n.domain.chat.core.room.application.OpenChatRoomService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/rooms/v1")
class OpenRoomController(
    private val openChatRoomService: OpenChatRoomService,
    private val timer: Timer,
) {
    @PostMapping
    fun openRoom(
        @Valid @RequestBody request: OpenRoomRequest,
    ): RoomResponse {
        val now = this.timer.now()

        val chatRoom = this.openChatRoomService.open(
            hostUserId = request.hostUserId,
            roomTitle = request.roomTitle,
            openDateTime = now,
        )
        return RoomResponse.of(chatRoom)
    }
}
