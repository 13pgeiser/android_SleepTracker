package com.example.android.trackmysleepquality.sleeptracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.TextItemViewHolder
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var data = listOf<SleepNight>()

    set(value) {
        field = value
        notifyDataSetChanged() // redraw everything: far from being a good idea...
    }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
                .inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }

    override fun onBindViewHolder(param: RecyclerView.ViewHolder, position: Int) {
        val holder : TextItemViewHolder = param as TextItemViewHolder
        val item = data[position]
        // Important, as views are re-used, all properties should be set
        if (item.sleepQuality <= 1) {
            holder.textView.setTextColor(Color.RED)
        } else {
            holder.textView.setTextColor(Color.BLACK)
        }
        holder.textView.text = item.sleepQuality.toString()
    }
}