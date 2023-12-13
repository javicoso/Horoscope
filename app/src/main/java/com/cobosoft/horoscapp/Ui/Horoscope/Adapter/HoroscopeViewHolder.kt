package com.cobosoft.horoscapp.Ui.Horoscope.Adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.cobosoft.horoscapp.Domain.model.HoroscopeInfo
import com.cobosoft.horoscapp.databinding.ItemHoroscopeBinding

class HoroscopeViewHolder(view:View):RecyclerView.ViewHolder(view) {


    private  val binding= ItemHoroscopeBinding.bind(view)


    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){

        binding.imgHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.text=binding.tvHoroscope.context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener{

            startRotationAnimation(binding.imgHoroscope, newLambda = {onItemSelected(horoscopeInfo)})
            //onItemSelected(horoscopeInfo)

        }



    }

    private fun startRotationAnimation(view: View, newLambda:()->Unit){

        view.animate().apply {

            duration=500;
            interpolator=LinearInterpolator()
            rotationBy(360f)
            withEndAction{newLambda()}
            start()
        }

    }


}