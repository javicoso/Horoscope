package com.cobosoft.horoscapp.Data.Providers.NetWork

import com.cobosoft.horoscapp.Data.Providers.NetWork.Response.HoroscopePredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign")sign:String) : HoroscopePredictionResponse



}