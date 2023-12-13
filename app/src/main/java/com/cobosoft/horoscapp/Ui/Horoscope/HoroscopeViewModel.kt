package com.cobosoft.horoscapp.Ui.Horoscope

import androidx.lifecycle.ViewModel
import com.cobosoft.horoscapp.Data.Providers.HoroscopeProviders
import com.cobosoft.horoscapp.Domain.model.HoroscopeInfo
import com.cobosoft.horoscapp.Domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProviders: HoroscopeProviders): ViewModel() {

    private var _horoscope= MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope


    init {
       _horoscope.value= horoscopeProviders.getHoroscope()
    }






}