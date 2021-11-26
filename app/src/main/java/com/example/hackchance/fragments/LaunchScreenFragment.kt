package com.example.hackchance.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
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