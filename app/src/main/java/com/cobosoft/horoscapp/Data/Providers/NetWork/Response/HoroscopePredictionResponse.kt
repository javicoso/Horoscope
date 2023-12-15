package com.cobosoft.horoscapp.Data.Providers.NetWork.Response

import com.cobosoft.horoscapp.Domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class HoroscopePredictionResponse (
    @SerializedName("date") val date:String,
    @SerializedName("horoscope") val horoscope:String,
    @SerializedName ("sign") val  sign:String
){
    fun toDomain():PredictionModel{
       return PredictionModel(horoscope = horoscope, sign = sign)

    }
}

