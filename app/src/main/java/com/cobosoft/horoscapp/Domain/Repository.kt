package com.cobosoft.horoscapp.Domain

import com.cobosoft.horoscapp.Data.Providers.NetWork.Response.HoroscopePredictionResponse
import com.cobosoft.horoscapp.Domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String):PredictionModel?
}