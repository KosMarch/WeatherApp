package com.example.weatherapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.adapters.DayAdapter
import com.example.weatherapp.databinding.FragmentDaysBinding

class DaysFragment : Fragment() {
    private lateinit var adapter: DayAdapter
    private lateinit var binding: FragmentDaysBinding
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
        model.currentResponse.observe(viewLifecycleOwner) {
            adapter.submitList(it.forecast.forecastday)
        }
    }

    private fun initRcView() = with(binding) {
        rcViewDays.layoutManager = LinearLayoutManager(activity)
        adapter = DayAdapter()
        rcViewDays.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = DaysFragment()
    }
}