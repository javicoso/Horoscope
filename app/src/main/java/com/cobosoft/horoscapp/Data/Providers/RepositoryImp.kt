package com.cobosoft.horoscapp.Data.Providers

import android.util.Log
import com.cobosoft.horoscapp.Data.Providers.NetWork.HoroscopeApiService
import com.cobosoft.horoscapp.Data.Providers.NetWork.Response.HoroscopePredictionResponse
import com.cobosoft.horoscapp.Domain.Repository
import com.cobosoft.horoscapp.Domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String):PredictionModel? {

        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("cobo", "Error${it.message}") }

        return null
    }
}