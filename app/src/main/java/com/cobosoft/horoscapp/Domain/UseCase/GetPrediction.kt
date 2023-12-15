package com.cobosoft.horoscapp.Domain.UseCase

import com.cobosoft.horoscapp.Domain.Repository
import javax.inject.Inject

class GetPrediction @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign:String) = repository.getPrediction(sign)

}