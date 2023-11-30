package com.cobosoft.horoscapp.Ui.Palm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cobosoft.horoscapp.databinding.FragmentPalmBinding


class PalmFragment : Fragment() {

    private var _binding: FragmentPalmBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}