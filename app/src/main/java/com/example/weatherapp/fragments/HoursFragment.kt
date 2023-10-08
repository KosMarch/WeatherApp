package com.example.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.adapters.WeatherAdapter
import com.example.weatherapp.adapters.WeatherModel
import com.example.weatherapp.databinding.FragmentHoursBinding
import org.json.JSONArray
import org.json.JSONObject

class HoursFragment : Fragment() {

    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
        model.liveDataCurrent.observe(viewLifecycleOwner) {
            adapter.submitList(getHourList(it))
        }
    }

    private fun initRcView() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter(null)
        rcView.adapter = adapter


    }

    private fun getHourList(item: WeatherModel): List<WeatherModel> {
        val hourArray = JSONArray(item.hours)
        val list = ArrayList<WeatherModel>()
        for (i in 0 until hourArray.length()) {
            val weatherItem = WeatherModel(
                item.city,
                (hourArray[i] as JSONObject).getString("time").substring(11),
                (hourArray[i] as JSONObject).getJSONObject("condition").getString("text"),
                (hourArray[i] as JSONObject).getString("temp_c"),
                "",
                "",
                (hourArray[i] as JSONObject).getJSONObject("condition").getString("icon"),
                ""
            )
            list.add(weatherItem)
        }
        return list
    }

    companion object {

        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}