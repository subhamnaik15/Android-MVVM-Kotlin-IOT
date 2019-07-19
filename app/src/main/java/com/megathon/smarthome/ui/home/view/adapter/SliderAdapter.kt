package com.megathon.smarthome.ui.home.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.megathon.smarthome.R
import com.megathon.smarthome.ui.home.model.HouseModel
import java.util.*

class SliderAdapter(private val content: ArrayList<HouseModel>, private val listener: View.OnClickListener?) :
    RecyclerView.Adapter<SliderAdapter.SliderCard>() {

    private val count: Int = content.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderCard {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_slider_card, parent, false)

        if (listener != null) {
            view.setOnClickListener { view -> listener.onClick(view) }
        }

        return SliderCard(view)
    }

    override fun onBindViewHolder(holder: SliderCard, position: Int) {
        holder.imageView.setBackgroundResource(content[position % content.size].pic)
    }

    override fun onViewRecycled(holder: SliderCard) {

    }

    override fun getItemCount(): Int {
        return count
    }

    inner class SliderCard(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById<View>(R.id.image) as ImageView

    }
}
