package com.example.grpckotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.grpckotlin.R
import com.example.grpckotlin.databinding.FragmentGreeterFragmentOneBinding
import com.example.grpckotlin.di.Injector

class GreeterFragmentOne : Fragment() {

    private lateinit var greeterViewModel: GreeterViewModel
    private lateinit var binding: FragmentGreeterFragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGreeterFragmentOneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        greeterViewModel = activity?.run {
            ViewModelProvider(this, Injector.provideGreeterViewModelFactory()).get(GreeterViewModel::class.java)
        } ?: throw Exception("Activity not found")

        greeterViewModel.greeting.observe(viewLifecycleOwner, Observer { greeting ->
            binding.fragment1ResultView.text = greeting
        })

        binding.fragment1SendBtn.setOnClickListener {
            greeterViewModel.sayHello(binding.fragment1InputField.text.toString())
        }
    }
}