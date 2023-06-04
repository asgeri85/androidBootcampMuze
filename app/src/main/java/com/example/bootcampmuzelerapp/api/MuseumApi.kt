package com.example.bootcampmuzelerapp.api

import com.example.bootcampmuzelerapp.model.CityResponse
import com.example.bootcampmuzelerapp.model.MuseumResponse
import com.example.bootcampmuzelerapp.utils.Constants.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MuseumApi {

    @GET("getCity")
    @Headers("Content-Type: application/json", "Authorization: Bearer $API_KEY")
    fun getAllCity(): Call<CityResponse>

    @GET("getMuseum")
    @Headers("Content-Type: application/json", "Authorization: Bearer $API_KEY")
    fun getAllMuseum(@Query("city") city: String): Call<MuseumResponse>

}