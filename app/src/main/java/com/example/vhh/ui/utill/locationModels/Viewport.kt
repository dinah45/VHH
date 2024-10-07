package com.example.vhh.ui.utill.locationModels

import kotlinx.serialization.Serializable

@Serializable
data class Viewport(
    val northeast: Northeast,
    val southwest: Southwest
)
