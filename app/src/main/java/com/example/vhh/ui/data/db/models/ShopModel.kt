package com.example.vhh.ui.data.db.models


import android.os.Parcelable
import androidx.room.Embedded
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class ShopModel(
    val address: String = "",
    val city: String = "",
    val country: String = "",
    val createdAt: String = "",
    val description: String = "",
    val followers: Int = 0,
    val followingCount: Int = 0,
    val id: String = "",
    val image: String = "",
    val isFollowing: Boolean = false,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val name: String = "",
    val state: String = "",
    val isPremium: Boolean = false,
    val hasBadge: Boolean = false,
    val premiumExpiresAt: String = "",
    val premiumStartedAt: String = "",
    val updatedAt: String = "",
    @Embedded(prefix = "user_")
    val user: User = User(),
    val userId: String = ""
) : Parcelable