package com.example.brorental.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.brorental.BroRentalApplication
import com.example.brorental.R
import com.example.brorental.databinding.FragmentSplashScreenBinding
import com.example.brorental.utils.SessionConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


class SplashScreenFragment : Fragment() {

    private var  _binding:FragmentSplashScreenBinding?=null
    private  val binding get()=_binding!!
    lateinit var app:BroRentalApplication
    lateinit var sessionConfig:SessionConfig



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding=FragmentSplashScreenBinding.inflate(inflater,container,false)
         app = requireActivity().application as BroRentalApplication
         sessionConfig = app.sharedPref

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(app.sharedPref.getFirstTime()){

            CoroutineScope(Dispatchers.Main).launch {
                delay(3000)
                findNavController().navigate(R.id.action_splashScreenFragment_to_startSliderFragment)
            }
        }else if(!app.sharedPref.getLogin()){
            CoroutineScope(Dispatchers.Main).launch {
                delay(3000)
                findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
            }
        }else if(!app.sharedPref.getTermConditions()){
            CoroutineScope(Dispatchers.Main).launch {
                delay(3000)
                findNavController().navigate(R.id.action_splashScreenFragment_to_termsAndconditionsFragment)
            }
        }
        else{
            CoroutineScope(Dispatchers.Main).launch {
                delay(3000)
                findNavController().navigate(R.id.action_splashScreenFragment_to_dashBoardFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}