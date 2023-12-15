package com.cobosoft.horoscapp.Ui.Detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cobosoft.horoscapp.Domain.UseCase.GetPrediction
import com.cobosoft.horoscapp.Domain.model.HoroscopeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor( private val getPrediction: GetPrediction):ViewModel(){

private  val _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state:StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope:HoroscopeModel

    fun  getHoroscope (sign: HoroscopeModel){
        horoscope= sign
        viewModelScope.launch {
            //HILO PRINCIPAL EN EL LAUNCH SECUDARIO EN EL DISPATCHER
            _state.value=HoroscopeDetailState.Loading
         val result=   withContext(Dispatchers.IO){
                getPrediction(sign.name)
            }

            if(result!=null){
                _state.value=HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            }else{
                _state.value=HoroscopeDetailState.Error("Ha ocurrido un Error")
            }


        }
    }



}