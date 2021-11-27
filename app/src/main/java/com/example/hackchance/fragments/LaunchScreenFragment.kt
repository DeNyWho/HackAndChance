package com.example.hackchance.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hackchance.R
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigation
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigationItem

@SuppressLint("CustomSplashScreen")
class LaunchScreenFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val handler = Handler()
        handler.postDelayed(3500) {
            findNavController().navigate(R.id.action_launchScreenFragment_to_signInFragment)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_launch_screen, container, false)

        return view
    }
}