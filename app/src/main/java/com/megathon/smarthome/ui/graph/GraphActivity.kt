package com.megathon.smarthome.ui.graph

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.megathon.smarthome.R
import com.megathon.smarthome.utility.CustomMarkerView
import com.megathon.smarthome.utility.MyValueFormatter

class GraphActivity : AppCompatActivity() {
    private lateinit var progressReportChart: LineChart
    private lateinit var staffAttChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        progressReportChart = findViewById<Button>(R.id.progressReportChart) as LineChart
        staffAttChart = findViewById<Button>(R.id.staffAttChart) as PieChart

        openChart()
        openCircleChart()
    }
    private fun openChart() {
        val entries = java.util.ArrayList<Entry>()
        val ent = java.util.ArrayList<Int>()
        val colors = java.util.ArrayList<Int>()
        ent.add(20)
        ent.add(32)
        ent.add(65)
        ent.add(70)
        ent.add(75)
        for (i in ent.indices) {
            entries.add(Entry(ent[i].toFloat(), i))
        }
        /*entries.add(new Entry(20f, 0));
        entries.add(new Entry(55f, 1));
        entries.add(new Entry(65f, 2));
        entries.add(new Entry(70f, 3));
        entries.add(new Entry(75f, 4));*/


        val dataset = LineDataSet(entries, "")
        val labels = java.util.ArrayList<String>()
        labels.add("a")
        labels.add("b")
        labels.add("c")
        labels.add("d")
        labels.add("e")
        labels.add("")

        for (i in ent.indices) {
            if (ent[i] < 33) {
                colors.add(Color.parseColor("#ff008577"))
                //dataset.setCircleColor(((Color.parseColor("#ff0000"))));
            } else
                colors.add(Color.parseColor("#24a6a4"))

        }

        val data = LineData(labels, dataset)
        //dataset.setColors(ColorTemplate.createColors(new int[]{(Color.parseColor("#24a6a4"))})); //
        // dataset.setDrawCubic(true);
        dataset.setDrawFilled(false)
        dataset.setDrawValues(true)
        dataset.setDrawCircles(true)
        dataset.setDrawCircleHole(false)
        dataset.circleColors = colors
        dataset.valueFormatter = MyValueFormatter() //for hiding decimal value in graph plotting
        dataset.valueTextColor = Color.parseColor("#212121")

        val xAxis = progressReportChart.getXAxis()
        xAxis.setAxisLineWidth(1f)
        xAxis.setAxisLineColor(Color.parseColor("#24a6a4"))
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xAxis.setAvoidFirstLastClipping(true)


        val leftAxis = progressReportChart.getAxisLeft()
        leftAxis.setAxisLineWidth(1f)
        leftAxis.setAxisLineColor(Color.parseColor("#24a6a4"))
        leftAxis.setStartAtZero(true)
        leftAxis.setAxisMaxValue(100f)

        //        Integer max_val = Collections.max(totalList);

        //        if(max_val<=10)
        //        {
        //            leftAxis.setAxisMaxValue(10);
        //            progressReportChart.getViewPortHandler().setMaximumScaleY(1f);
        //        }
        //
        //        else
        //        {
        //            leftAxis.setAxisMaxValue(max_val+5);
        //            progressReportChart.getViewPortHandler().setMaximumScaleY(2f);
        //        }

        progressReportChart.setDescription("")
        progressReportChart.setDrawGridBackground(false)
        progressReportChart.getAxisRight().setEnabled(false)
        progressReportChart.getXAxis().setDrawGridLines(false)
        progressReportChart.getAxisLeft().setDrawGridLines(false)

        // chartContainer.removeAllViews();
        //lineChart.getViewPortHandler().setMaximumScaleY(0f);
        progressReportChart.setData(data)
        progressReportChart.animateY(1000)
        progressReportChart.getLegend().setEnabled(false)

        progressReportChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry, dataSetIndex: Int, h: Highlight) {
                val mv = CustomMarkerView(this@GraphActivity, R.layout.marker_layout)
                progressReportChart.setMarkerView(mv)

            }

            override fun onNothingSelected() {

            }
        })
    }

    private fun openCircleChart() {
        staffAttChart.setTouchEnabled(false)
        staffAttChart.setUsePercentValues(true)
        val yvalues = java.util.ArrayList<Entry>()
        yvalues.add(Entry(50f, 0))
        yvalues.add(Entry(33f, 1))
        yvalues.add(Entry(17f, 2))


        val dataSet = PieDataSet(yvalues, "staff Results")
        val colorlist = java.util.ArrayList<Int>()
        colorlist.add(Color.parseColor("#26aa8a"))
        colorlist.add(Color.parseColor("#f19b1f"))
        colorlist.add(Color.parseColor("#cd3147"))

        dataSet.colors = colorlist
        val xVals = java.util.ArrayList<String>()

        xVals.add("")
        xVals.add("")
        xVals.add("")


        val data = PieData(xVals, dataSet)
        //        data.setValueFormatter(new PercentFormatter());
        staffAttChart.data = data
        staffAttChart.isDrawHoleEnabled = true
        staffAttChart.transparentCircleRadius = 30f

        staffAttChart.holeRadius = 45f
        data.setValueTextSize(7f)
        data.setValueTextColor(Color.WHITE)
        staffAttChart.animateY(1000)
        staffAttChart.legend.isEnabled = false
        staffAttChart.setDescription("")
        staffAttChart.setCenterText("%")
        staffAttChart.setCenterTextColor(Color.parseColor("#045187"))
        staffAttChart.invalidate()

    }
}
