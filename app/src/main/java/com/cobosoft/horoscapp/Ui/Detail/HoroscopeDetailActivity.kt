package com.cobosoft.horoscapp.Ui.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.cobosoft.horoscapp.Domain.model.HoroscopeModel
import com.cobosoft.horoscapp.Domain.model.HoroscopeModel.*
import com.cobosoft.horoscapp.R
import com.cobosoft.horoscapp.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHoroscopeDetailBinding

    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()
    private val args: HoroscopeDetailActivityArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

        horoscopeDetailViewModel.getHoroscope(args.type)
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {

        binding.imgBack.setOnClickListener {
            onBackPressed()
        }

    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)

                    }
                }
            }
        }

    }

    private fun loadingState() {
        binding.pbhoroscope.isVisible = true
    }

    private fun errorState() {

    }

    private fun successState(state: HoroscopeDetailState.Success) {

        binding.pbhoroscope.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction


        val image = when (state.horoscopeModel) {
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }

        binding.imgDetail.setImageResource(image)


    }
}