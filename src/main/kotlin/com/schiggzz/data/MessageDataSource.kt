package com.schiggzz.data

import com.schiggzz.data.model.Message

interface MessageDataSource {

    suspend fun getAllMessages(): List<Message>

    suspend fun insertMessage(message: Message)
}