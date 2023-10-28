package com.example.brorental.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.example.brorental.ui.fragments.RentFragment
import com.example.brorental.ui.fragments.RideFragment

class TabLayoutPagerAdaptor (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int { return 2}

    override fun createFragment(position: Int): Fragment{
        return if(position == 0){
            RentFragment()
        }else{
            RideFragment()
        }
    }
}