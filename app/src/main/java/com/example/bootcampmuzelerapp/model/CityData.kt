package com.example.bootcampmuzelerapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityData(
    val id: Int,
    val sehir: String,
    val slug: String
) : Parcelable