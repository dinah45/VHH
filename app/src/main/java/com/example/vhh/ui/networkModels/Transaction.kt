package com.example.vhh.ui.networkModels

import android.os.Parcelable
import com.example.vhh.ui.data.db.models.User
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Transaction(
    val amount: Double = 0.0,
    val createdAt: String = "",
    val currencyId: String = "",
    val description: String = "",
    val id: String = "",
    val image: String = "",
    val ref: String = "",
    val sourceId: String = "",
    val status: String = "",
    val type: String = "",
    val updatedAt: String = "",
    val user: User = User(),
    val userId: String = "",
) : Parcelable

@Serializable
data class TransactionResponse(
    val data: List<Transaction> = listOf(),
    val meta: Pagination = Pagination(),
)