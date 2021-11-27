package com.example.hackchance.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.hackchance.R
import com.google.android.material.tabs.TabLayout
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigation
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigationItem
import com.tenclouds.fluidbottomnavigation.listener.OnTabSelectedListener

class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        val fluidBottomNavigation = view.findViewById<FluidBottomNavigation>(R.id.fluidBottomNavigation)
        fluidBottomNavigation.selectTab(3)
        fluidBottomNavigation.accentColor = ContextCompat.getColor(requireContext(), R.color.background)
        fluidBottomNavigation.backColor = ContextCompat.getColor(requireContext(), R.color.background)
        fluidBottomNavigation.textColor = ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark)
        fluidBottomNavigation.iconColor = ContextCompat.getColor(requireContext(), R.color.colorPrimary)
        fluidBottomNavigation.iconSelectedColor = ContextCompat.getColor(requireContext(), R.color.iconSelectedColor)

        fluidBottomNavigation.items =
            listOf(
                FluidBottomNavigationItem(
                    getString(R.string.profile),
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_profile)),
                FluidBottomNavigationItem(
                    getString(R.string.message),
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_mess)),
                FluidBottomNavigationItem(
                    getString(R.string.main),
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_main)),
                FluidBottomNavigationItem(
                    getString(R.string.notification),
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_notif)),
                FluidBottomNavigationItem(
                    getString(R.string.settings),
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_settings))
            )
        fluidBottomNavigation.onTabSelectedListener = object: TabLayout.OnTabSelectedListener,
            OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabSelected(position: Int) {
                when(position){
                    0 -> findNavController().navigate(R.id.action_notificationFragment_to_profileFragment)
                    1 -> findNavController().navigate(R.id.action_notificationFragment_to_messageFragment)
                    2 -> findNavController().navigate(R.id.action_notificationFragment_to_mainFragment)
                    4 -> findNavController().navigate(R.id.action_notificationFragment_to_settingsFragment)
                }
            }
        }
        return view
    }

}