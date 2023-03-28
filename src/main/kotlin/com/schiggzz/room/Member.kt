package com.schiggzz.room

import io.ktor.http.cio.websocket.*

class Member (
    val username: String,
    val sessionId: String,
    val socket: WebSocketSession
    )