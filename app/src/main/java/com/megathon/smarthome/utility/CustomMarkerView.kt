package com.megathon.smarthome.utility

import android.content.Context
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.megathon.smarthome.R


class CustomMarkerView(context: Context, layoutResource: Int) : MarkerView(context, layoutResource) {

    private val tvContent: TextView

    init {
        // this markerview only displays a textview
        tvContent = findViewById(R.id.tvContent) as TextView
    }

    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    override fun refreshContent(e: Entry, highlight: Highlight) {
        //        tvContent.setText("(" + e.getVal()+")"); // set the entry-value as the display text
        tvContent.text = "(Midterm 1)" // set the entry-value as the display text
    }

    override fun getXOffset(xpos: Float): Int {
        // this will center the marker-view horizontally
        return -(width / 8)
    }

    override fun getYOffset(ypos: Float): Int {
        // this will cause the marker-view to be above the selected value
        return -(height / 8)
    }
}