package com.example.brorental.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.brorental.BroRentalApplication
import com.example.brorental.R
import com.example.brorental.databinding.FragmentDashBoardBinding
import com.example.brorental.ui.activities.UploadBikes
import com.example.brorentalapp.MainContentFragment
import com.google.android.material.navigation.NavigationView


class DashBoardFragment : Fragment() {

    private var _binding :FragmentDashBoardBinding?=null
    private  val binding get()=_binding!!

    lateinit var app:BroRentalApplication
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var toolbar: Toolbar
    private lateinit var vNV: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding=FragmentDashBoardBinding.inflate(inflater,container,false)

        app=BroRentalApplication()

        toolbar = binding.toolbar
        drawerLayout = binding.myDrawerLayout
        vNV = binding.navigationView

        // Set the toolbar as the action bar
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)

        // Drawer layout instance to toggle the menu icon to open
        // drawer and back button to close the drawer
        actionBarDrawerToggle = ActionBarDrawerToggle(
            requireActivity(),
            drawerLayout,
            toolbar,
            R.string.nav_open,
            R.string.nav_close
        )

        // Pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        if (savedInstanceState == null) {
            vNV.setCheckedItem(R.id.nav_account)
        }

        // To make the Navigation drawer icon always appear on the action bar
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navClick()



        return binding.root
    }
    private fun navClick() {
        vNV.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_account -> {
                    switchToFragment(MainContentFragment())
                    Toast.makeText(requireContext(), "My Account", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_Rides -> {
                    switchToFragment(RentFragment())
                    Toast.makeText(requireContext(), "Rides", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_logout -> {
                    Toast.makeText(requireContext(), "Logout", Toast.LENGTH_SHORT).show()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

 /*   override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }*/




    fun switchToFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container_frame_dash, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}