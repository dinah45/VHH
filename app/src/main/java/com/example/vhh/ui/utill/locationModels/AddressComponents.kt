package com.example.vhh.ui.utill.locationModels


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AddressComponent(
    @SerialName("long_name")
    val longName: String,
    @SerialName("short_name")
    val shortName: String,
    val types: List<String>
)