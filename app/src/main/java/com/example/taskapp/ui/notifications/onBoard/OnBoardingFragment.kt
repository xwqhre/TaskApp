package com.example.taskapp.ui.notifications.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.example.taskapp.adapter.utils.showToast
import com.example.taskapp.databinding.FragmentOnBoardingBinding
import com.example.taskapp.databinding.FragmentProfileBinding
import com.example.taskapp.model.onBoard
import com.example.taskapp.ui.notifications.onBoard.adapter.onBoardingAdapter


class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = onBoardingAdapter(this::onClick)
        binding.viewPager.adapter= adapter
    }
    private fun onClick(onBoard: onBoard){
        findNavController().navigateUp()
    }
}