package com.example.hackchance.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hackchance.R

@SuppressLint("CustomSplashScreen")
class LaunchScreenFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val handler = Handler()
        handler.postDelayed(2500) {
            findNavController().navigate(R.id.action_launchScreenFragment_to_signInFragment)
        }
    }
}