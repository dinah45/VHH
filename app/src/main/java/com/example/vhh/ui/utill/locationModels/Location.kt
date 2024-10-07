package com.example.vhh.ui.utill.locationModels


import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val lat: Double?,
    val lng: Double?
)