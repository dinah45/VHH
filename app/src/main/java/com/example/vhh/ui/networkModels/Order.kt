package com.example.vhh.ui.networkModels

import android.os.Parcelable
import com.example.vhh.ui.data.db.models.Listing
import com.example.vhh.ui.data.db.models.User
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Order(
    val cancelReason: String = "",
    val conversationId: String = "",
    val createdAt: String = "",
    val currency: CurrencyRate = CurrencyRate(),
    val currencySymbol: String = "",
    val deliveryAddress: String = "",
    val deliveryBy: User = User(),
    val deliveryFee: Double = 0.0,
    val deliveryById: String = "",
    val deliveredImage: String = "",
    val id: String = "",
    val latitude: Double = 0.0,
    val listing: Listing = Listing(),
    val listingId: String = "",
    val longitude: Double = 0.0,
    val pickedUpImage: String = "",
    val quantity: Int = 0,
    val rating: Rating = Rating(),
//    val shop: ShopModel = ShopModel(),
    val shopId: String = "",
    val status: String = "",
    val unitPrice: Double = 0.0,
    val updatedAt: String = "",
    val user: User = User(),
    val userId: String = "",
    val waitTime: String = "",
    val meta: Meta = Meta(),
    val title: String = "",
    val description: String = "",
    val image: String = "",
    val jobId: String = "",
) : Parcelable


@Serializable
@Parcelize
data class Rating(
    val createdAt: String = "",
    val dispatchMessage: String = "",
    val dispatchRating: Int = 0,
    val id: String = "",
    val orderId: String = "",
    val shopMessage: String = "",
    val shopRating: Int = 0,
    val updatedAt: String = "",
    val user: User = User(),
    val userId: String = "",
    val userMessage: String = "",
    val userRating: Int = 0
) : Parcelable


@Serializable
data class OrderResponse(
    val data: List<Order> = listOf(),
    val meta: Pagination = Pagination(),
)