package com.cobosoft.horoscapp.Ui.Luck

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.cobosoft.horoscapp.R
import com.cobosoft.horoscapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LuckFragment : Fragment() {


    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        initListener()
    }

    private fun initListener() {
        binding.ivRullette.setOnClickListener {
            spinRulette()
        }
    }

    private fun spinRulette() {

        val random = java.util.Random()

        val degrees = random.nextInt(1440) + 360


        val animator =
            ObjectAnimator.ofFloat(binding.ivRullette, View.ROTATION, 0f, degrees.toFloat())

        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { slideCard() }
        animator.start()

    }

    private fun slideCard() {

        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)

        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                binding.reverse.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {

                growCard()

            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })

        binding.reverse.startAnimation(slideUpAnimation)


    }

    private fun growCard() {

        val growAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.grow_card)
        growAnimation.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {

                binding.reverse.isVisible=false
                showPremonitionView()

            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })

        binding.reverse.startAnimation(growAnimation)


    }

    private fun  showPremonitionView(){

        val disappearAnimation= AlphaAnimation(1.0f,0.0f)
        disappearAnimation.duration=200

        val appearAnimation = AlphaAnimation(0.0f,1.0f)
        appearAnimation.duration=1000

        disappearAnimation.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {

                binding.preview.isVisible=false
                binding.prediction.isVisible=true
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })

        binding.preview.startAnimation(disappearAnimation)
        binding.prediction.startAnimation(appearAnimation)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}