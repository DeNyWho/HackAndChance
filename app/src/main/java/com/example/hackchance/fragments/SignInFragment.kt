package com.example.hackchance.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hackchance.R

class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        val next = view.findViewById<AppCompatButton>(R.id.next)

        next.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
        }


        return view
    }

}