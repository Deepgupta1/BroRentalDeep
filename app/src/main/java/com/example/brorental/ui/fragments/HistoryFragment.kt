package com.example.brorentalapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.brorental.databinding.FragmentHistoryBinding
import com.example.brorental.databinding.FragmentRentBinding
import com.example.brorental.ui.adapters.TabLayoutPagerAdaptor
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val view = binding.root

        // Set up the TabLayout and ViewPager
        val tabLayout: TabLayout = binding.tabFrame
        val viewPager: ViewPager2 = binding.pagerFrame
        val adapter = TabLayoutPagerAdaptor(requireActivity().supportFragmentManager, lifecycle)
        tabLayout.addTab(tabLayout.newTab().setText("Rent"))
        tabLayout.addTab(tabLayout.newTab().setText("Rides"))

        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabNames = listOf("Rent", "Rides")
            tab.text = tabNames[position]
        }.attach()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
