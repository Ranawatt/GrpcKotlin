package com.example.grpckotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.grpckotlin.databinding.FragmentGreeterFragmentTwoBinding
import com.example.grpckotlin.di.Injector

class GreeterFragmentTwo : Fragment() {

    private lateinit var greeterViewModel: GreeterViewModel
    private lateinit var binding: FragmentGreeterFragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGreeterFragmentTwoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        greeterViewModel = activity?.run {
            ViewModelProvider(this, Injector.provideGreeterViewModelFactory()).get(GreeterViewModel::class.java)
        } ?: throw Exception("Activity not found")

        greeterViewModel.greeting.observe(viewLifecycleOwner, Observer { greeting ->
            binding.fragment2ResultView.text = greeting
        })

        binding.fragment2SendBtn.setOnClickListener {
            greeterViewModel.sayHello(binding.fragment2InputField.text.toString())
        }
    }
}