package com.example.brorental.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.brorental.BroRentalApplication
import com.example.brorental.R
import com.example.brorental.databinding.FragmentTermsAndconditionsBinding
import com.example.brorental.utils.SessionConfig
import javax.inject.Inject

class TermsAndconditionsFragment : Fragment() {

    private var _binding: FragmentTermsAndconditionsBinding? = null
    private val binding get() = _binding!!

    
    lateinit var sessionConfig: SessionConfig
    lateinit var app:BroRentalApplication


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTermsAndconditionsBinding.inflate(inflater, container, false)
        app = requireActivity().application as BroRentalApplication
        sessionConfig = app.sharedPref
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitBtn.setOnClickListener{
            if(!binding.termsRBtn.isChecked){
                Toast.makeText(requireContext(),"please accept Terms and Conditions",Toast.LENGTH_SHORT).show()
            }else{
                sessionConfig.setTermConditions(true)
                findNavController().navigate(R.id.action_termsAndconditionsFragment_to_dashBoardFragment)

            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}