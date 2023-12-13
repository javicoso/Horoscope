package com.cobosoft.horoscapp.Data.Providers

import com.cobosoft.horoscapp.Domain.model.HoroscopeInfo
import com.cobosoft.horoscapp.Domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProviders @Inject constructor(){
    fun getHoroscope(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}