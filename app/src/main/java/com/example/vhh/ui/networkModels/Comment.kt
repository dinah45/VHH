package com.example.vhh.ui.networkModels


import android.os.Parcelable
import androidx.room.Embedded
import com.example.vhh.ui.data.db.models.User
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Comment(
    val content: String,
    val createdAt: String,
    val id: String,
    val isLiked: Boolean,
    val listingId: String,
    val totalLikes: Int,
    val updatedAt: String,
    @Embedded(prefix = "user_")
    val user: User,
    val userId: String
) : Parcelable

@Serializable
data class CommentResponse(
    val data: List<Comment> = listOf(),
    val meta: Pagination = Pagination(),
)