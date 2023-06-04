package com.example.bootcampmuzelerapp.model

data class CityResponse(
    val `data`: List<CityData>,
    val message: String,
    val rowCount: Int,
    val status: String
)