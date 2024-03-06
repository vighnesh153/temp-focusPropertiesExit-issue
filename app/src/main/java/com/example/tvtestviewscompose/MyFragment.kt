package com.example.tvtestviewscompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tvtestviewscompose.databinding.MyFragmentBinding

class MyFragment : Fragment() {
    private lateinit var binding: MyFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }
}