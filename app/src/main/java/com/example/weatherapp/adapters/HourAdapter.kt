package com.example.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ListItemBinding
import com.example.weatherapp.network.WeatherHour
import com.squareup.picasso.Picasso

class HourAdapter : ListAdapter<WeatherHour, HourAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListItemBinding.bind(view)
        fun bind(item: WeatherHour) = with(binding) {
            tvDate.text = item.time.substring(11)
            tvConditionList.text = item.condition.text
            tvTemp.text = item.temp_c
            Picasso.get().load("https:" + item.condition.icon).into(imCondition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class Comparator : DiffUtil.ItemCallback<WeatherHour>() {
        override fun areItemsTheSame(oldItem: WeatherHour, newItem: WeatherHour): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherHour, newItem: WeatherHour): Boolean {
            return oldItem == newItem
        }
    }
}