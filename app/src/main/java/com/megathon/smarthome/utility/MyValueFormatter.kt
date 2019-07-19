package com.megathon.smarthome.utility

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ViewPortHandler

import java.text.DecimalFormat


class MyValueFormatter : ValueFormatter {

    private val mFormat: DecimalFormat

    init {
        mFormat = DecimalFormat("###,###,##0") // use one decimal
    }

    override fun getFormattedValue(
        value: Float,
        entry: Entry,
        dataSetIndex: Int,
        viewPortHandler: ViewPortHandler
    ): String {
        // write your logic here
        return mFormat.format(value.toDouble()) // e.g. append a dollar-sign
    }
}
