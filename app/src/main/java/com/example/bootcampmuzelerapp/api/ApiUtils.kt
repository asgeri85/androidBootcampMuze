package com.example.bootcampmuzelerapp.api

import com.example.bootcampmuzelerapp.utils.Constants.BASE_URL

class ApiUtils {
    companion object {
        fun getMuseumApi(): MuseumApi {
            return RetrofitClient.getRetrofitClient(BASE_URL).create(MuseumApi::class.java)
        }
    }
}