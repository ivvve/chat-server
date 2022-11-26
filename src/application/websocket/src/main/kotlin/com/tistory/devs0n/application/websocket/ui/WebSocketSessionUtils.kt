package com.tistory.devs0n.application.websocket.ui

import com.tistory.devs0n.application.websocket.ui.connection.Connection
import org.springframework.web.socket.WebSocketSession

private const val CONNECTION_ATTRIBUTE_NAME = "connection"

fun WebSocketSession.getConnection(): Connection {
    return this.attributes[CONNECTION_ATTRIBUTE_NAME] as Connection
}

fun WebSocketSession.setConnection(connection: Connection) {
    this.attributes[CONNECTION_ATTRIBUTE_NAME] = connection
}
