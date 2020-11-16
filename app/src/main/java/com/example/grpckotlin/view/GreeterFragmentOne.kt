package com.example.grpckotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.grpckotlin.R
import com.example.grpckotlin.di.Injector
import kotlinx.android.synthetic.main.fragment_greeter_fragment_one.*

class GreeterFragmentOne : Fragment() {

    private lateinit var greeterViewModel: GreeterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_greeter_fragment_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        greeterViewModel = activity?.run {
            ViewModelProvider(this, Injector.provideGreeterViewModelFactory()).get(GreeterViewModel::class.java)
        } ?: throw Exception("Activity not found")

        greeterViewModel.greeting.observe(viewLifecycleOwner, Observer { greeting ->
            fragment1ResultView.text = greeting
        })

        fragment1SendBtn.setOnClickListener {
            greeterViewModel.sayHello(fragment1InputField.text.toString())
        }
    }
}