package com.example.brorentalapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brorental.R
import com.example.brorental.databinding.FragmentMainContentfragmentBinding
import com.example.brorental.model.TopRides
import com.example.brorental.ui.activities.UploadBikes
import com.example.brorental.ui.adapters.TopRidesRecycler


class MainContentFragment : Fragment() {
    private var _binding: FragmentMainContentfragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainContentfragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        // Access views using ViewBinding
        val recyclerView = binding.topRidesView
        recyclerView.layoutManager = LinearLayoutManager(context)
        val rupeeSymbol = "\u20B9"

       // val ride = listOf<TopRides>()
        val ride = listOf(
            TopRides(R.drawable.cycle_1, "A", "Motorbike", "$rupeeSymbol 100/day"),
            TopRides(R.drawable.cycle_2, "B", "Scooty", "$rupeeSymbol 200/day"),
            TopRides(R.drawable.cycle_3, "C", "Scooty", "$rupeeSymbol 300/day"),
            TopRides(R.drawable.cycle4, "D", "Motorbike", "$rupeeSymbol 400/day"),
            TopRides(R.drawable.cycle5, "E", "Motorbike", "$rupeeSymbol 500/day")
        )
        val rideAdapter = TopRidesRecycler(ride)
        recyclerView.adapter = rideAdapter

        binding.addBtn.setOnClickListener{

            addBtn()
           // Toast.makeText(requireActivity(),"Add Button Click",Toast.LENGTH_SHORT).show();
        }

        return view
    }
    fun addBtn() {
        val intent = Intent(requireActivity(), UploadBikes::class.java)
        startActivity(intent)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
