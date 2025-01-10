package com.example.vhh.ui.networkModels


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class CurrencyRate(
    val amount: String = "",
    val contractAddr: String? = "",
    val createdAt: String = "",
    val exchangeRate: Double = 0.0,
    val icon: String = "",
    val id: String = "",
    val isActive: Boolean = false,
    val name: String = "",
    val symbol: String = "",
    val type: String = "",
    val updatedAt: String = "",
    val withdrawalFee: Double = 0.0,
    val pin: String = "",
    val coupon: String = "",
) : Parcelable

@Serializable
@Parcelize
data class CouponRes(
    val payableAmount: Double = 0.0,
    val currency: CurrencyRate = CurrencyRate(),
) : Parcelable
