package com.example.vhh.ui.networkModels

import android.os.Parcelable
import com.example.vhh.ui.data.db.models.User
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Conversation(
    val byUserId: String = "",
    val createdAt: String = "",
    val deletedBy: List<String> = listOf(),
    val forAdmins: Boolean = false,
    val id: String = "",
    val isActive: Boolean = false,
    val recentMessage: Message = Message(),
    val shopId: String = "",
    val updatedAt: String = "",
    val unreadCount: Int = 0,
    val display: Display = Display(),
    val proposalId: String? = null,
    val Order: Order? = null,
) : Parcelable

@Serializable
@Parcelize
data class Display(
    val image: String = "",
    val isOnline: Boolean = false,
    val name: String = "",
) : Parcelable

@Serializable
@Parcelize
data class Message(
    val conversationId: String = "",
    val createdAt: String = "",
    val id: String = "",
    val isDeleted: Boolean = false,
    val deliveredTo: List<String> = listOf(),
    val readBy: List<String> = listOf(),
    val media: String? = null,
    val replyToId: String = "",
    val replyTo: Message? = null,
    val text: String = "",
    val updatedAt: String = "",
    val userId: String = "",
    val user: User = User(),
    val type: String = "MESSAGE",
) : Parcelable


@Serializable
data class ConversationResponse(
    val data: List<Conversation> = listOf(),
    val meta: Pagination = Pagination(),
)

@Serializable
data class MessageResponse(
    val data: List<Message> = listOf(),
    val meta: Pagination = Pagination(),
)