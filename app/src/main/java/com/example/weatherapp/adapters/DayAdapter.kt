package com.example.weatherapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ListItemBinding
import com.example.weatherapp.network.WeatherForecastDay
import com.squareup.picasso.Picasso

class DayAdapter : ListAdapter<WeatherForecastDay,
        DayAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListItemBinding.bind(view)
        private var itemTemp: WeatherForecastDay? = null

        @SuppressLint("SetTextI18n")
        fun bind(item: WeatherForecastDay) = with(binding) {
            itemTemp = item

            tvDate.text = item.date
            tvConditionList.text = item.hour[0].condition.text
            tvTemp.text = "${item.day.maxtemp_c} / ${item.day.mintemp_c}"
            Picasso.get().load("https:" + item.hour[0].condition.icon).into(imCondition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class Comparator : DiffUtil.ItemCallback<WeatherForecastDay>() {
        override fun areItemsTheSame(
            oldItem: WeatherForecastDay,
            newItem: WeatherForecastDay
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: WeatherForecastDay,
            newItem: WeatherForecastDay
        ): Boolean {
            return oldItem == newItem
        }
    }
}