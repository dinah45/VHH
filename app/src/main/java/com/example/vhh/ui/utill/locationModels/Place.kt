package com.example.vhh.ui.utill.locationModels

import kotlinx.serialization.Serializable

@Serializable
data class Place(
    val results: List<LocationResult> = emptyList(),
    val status: String
)