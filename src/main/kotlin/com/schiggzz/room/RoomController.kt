package com.schiggzz.room

import com.schiggzz.data.MessageDataSource
import com.schiggzz.data.model.Message
import io.ktor.http.cio.websocket.*
import java.util.concurrent.ConcurrentHashMap

class RoomController (
    private val messageDataSource: MessageDataSource
) {
    private val members = ConcurrentHashMap<String, Member>()

    fun onJoin(
        username: String,
        sessionId: String,
        socket: WebSocketSession
    ) {
        if(members.containsKey(username)) {
            throw MemberAlreadyExistsException()
        }

        members[username] = Member(
            username = username,
            sessionId = sessionId,
            socket = socket
        )
    }

    fun sendMessage(senderUsername: String, message: String) {
        members.values.forEach {member ->
            val messageEntity = Message(
                text = message,
                username = senderUsername,
                timestamp = System.currentTimeMillis()
            )

        }
    }

}
