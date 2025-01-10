package com.example.vhh.ui.networkModels

import com.example.vhh.ui.data.db.models.ShopModel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Proposal(
    val id: String = "",
    val shop: ShopModel = ShopModel(),
    val shopId: String = "",
    val jobId: String = "",
    val message: String = "",
    val media: List<String> = listOf(),
    val status: String = "",
    val proposedPrice: Double = 0.0,
    val proposedDeadline: String = "",
    val createdAt: String = "",
    val updatedAt: String = "",
//    val job: JobModel = JobModel(),
) : Parcelable

@Serializable
data class ProposalResponse(
    val data: List<Proposal> = listOf(),
    val meta: Pagination = Pagination(),
)
