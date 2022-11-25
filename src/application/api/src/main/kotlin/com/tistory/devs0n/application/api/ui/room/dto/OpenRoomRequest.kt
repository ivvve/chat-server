package com.tistory.devs0n.application.api.ui.room.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank

data class OpenRoomRequest(
    @field:JsonProperty("host_user_id")
    @field:NotBlank
    val hostUserId: String,

    @field:JsonProperty("room_title")
    @field:NotBlank
    val roomTitle: String,
)
