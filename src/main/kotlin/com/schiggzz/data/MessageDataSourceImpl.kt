package com.schiggzz.data

import com.schiggzz.data.model.Message
import io.ktor.util.reflect.*
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.insertOne

class MessageDataSourceImpl(
    private val db: CoroutineDatabase
): MessageDataSource {

    private val messages = db.getCollection<Message>()

    override suspend fun getAllMessages(): List<Message> {
        return messages.find().descendingSort(Message::timestamp).toList()
    }

    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }
}