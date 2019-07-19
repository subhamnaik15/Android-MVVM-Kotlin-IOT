package com.megathon.smarthome.ui.home.view


import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ViewSwitcher
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.megathon.smarthome.ui.home.model.HouseModel
import com.megathon.smarthome.ui.home.view.adapter.SliderAdapter
import com.megathon.smarthome.R
import com.megathon.smarthome.SmartHomeBaseFragment
import com.megathon.smarthome.ui.graph.GraphActivity
import com.megathon.smarthome.ui.home.view.cardSlider.CardSliderLayoutManager
import com.megathon.smarthome.ui.home.view.cardSlider.CardSnapHelper


/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : SmartHomeBaseFragment<com.megathon.smarthome.databinding.FragmentHomeBinding>() {
    override fun layoutId(): Int = R.layout.fragment_home


    private val pics = intArrayOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5
    )
    private val descriptions =
        intArrayOf(
            R.string.text1,
            R.string.text2,
            R.string.text3,
            R.string.text4,
            R.string.text5
        )
    private val countries = arrayOf("KITCHEN", "HALL", "BATHROOM", "ROOM1", "ROOM2")
    private val places = arrayOf("About", "About", "About", "About", "About")
    private val temperatures = arrayOf("21°C", "19°C", "17°C", "23°C", "20°C")
    private val times = arrayOf(
        "Aug 1 - Dec 15    7:00-18:00",
        "Sep 5 - Nov 10    8:00-16:00",
        "Mar 8 - May 21    7:00-18:00",
        "Aug 1 - Dec 15    7:00-18:00",
        "Sep 5 - Nov 10    8:00-16:00"
    )

    private var houseModelArrayList: ArrayList<HouseModel>? = null
    private var sliderAdapter: SliderAdapter? = null

    private var layoutManger: CardSliderLayoutManager? = null
    private var countryOffset1: Int = 0
    private var countryOffset2: Int = 0
    private var countryAnimDuration: Long = 0
    private var currentPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_home, container, false)
//        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setValue()
        initRecyclerView()
        initCountryText()
        initSwitchers()
        initListner()

        vb.graphImage.setAnimation("raw/graph.json")
        vb.graphImage.repeatCount = 1
        vb.graphImage.tag = "INACTIVE"
        vb.graphImage.playAnimation()

        return vb.root
    }

    private fun initListner() {

        vb.graphImage.setOnClickListener {
            val intent = (Intent(activity, GraphActivity::class.java))
            startActivity(intent)
        }
    }


    private fun setValue() {
        houseModelArrayList = ArrayList()
        val house1 = HouseModel()
        house1.pic = pics[0]
        house1.descriptions = getString(descriptions[0])
        house1.name = countries[0]
        house1.place = places[0]
        house1.temperature = temperatures[0]
        house1.time = times[0]
        houseModelArrayList!!.add(house1)

        val house2 = HouseModel()
        house2.pic = pics[1]
        house2.descriptions = getString(descriptions[1])
        house2.name = countries[1]
        house2.place = places[1]
        house2.temperature = temperatures[1]
        house2.time = times[1]
        houseModelArrayList!!.add(house2)


        val house3 = HouseModel()
        house3.pic = pics[2]
        house3.descriptions = getString(descriptions[2])
        house3.name = countries[2]
        house3.place = places[2]
        house3.temperature = temperatures[2]
        house3.time = times[2]
        houseModelArrayList!!.add(house3)

        val house4 = HouseModel()
        house4.pic = pics[3]
        house4.descriptions = getString(descriptions[3])
        house4.name = countries[3]
        house4.place = places[3]
        house4.temperature = temperatures[3]
        house4.time = times[3]
        houseModelArrayList!!.add(house4)


        val house5 = HouseModel()
        house5.pic = pics[4]
        house5.descriptions = getString(descriptions[4])
        house5.name = countries[4]
        house5.place = places[4]
        house5.temperature = temperatures[4]
        house5.time = times[4]
        houseModelArrayList!!.add(house5)


        sliderAdapter =
            SliderAdapter(houseModelArrayList!!, OnCardClickListener())
    }

    private fun initRecyclerView() {
        vb.recyclerView.adapter = sliderAdapter
        vb.recyclerView.setHasFixedSize(true)

        vb.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    onActiveCardChange()
                }
            }
        })

        layoutManger = vb.recyclerView.layoutManager as CardSliderLayoutManager?

        CardSnapHelper().attachToRecyclerView(vb.recyclerView)
    }

    private fun initSwitchers() {
        vb.tsTemperature.setFactory(TextViewFactory(R.style.TemperatureTextView, true))
        vb.tsTemperature.setCurrentText(houseModelArrayList!![0].temperature)

        vb.tsPlace.setFactory(TextViewFactory(R.style.PlaceTextView, false))
        vb.tsPlace.setCurrentText(houseModelArrayList!![0].place)

        vb.tsClock.setFactory(TextViewFactory(R.style.ClockTextView, false))
        vb.tsClock.setCurrentText(houseModelArrayList!![0].time)

        vb.tsDescription.setInAnimation(activity, android.R.anim.fade_in)
        vb.tsDescription.setOutAnimation(activity, android.R.anim.fade_out)
        vb.tsDescription.setFactory(TextViewFactory(R.style.DescriptionTextView, false))
        vb.tsDescription.setCurrentText(houseModelArrayList!![0].descriptions)

    }

    private fun initCountryText() {
        countryAnimDuration = resources.getInteger(R.integer.labels_animation_duration).toLong()
        countryOffset1 = resources.getDimensionPixelSize(R.dimen.left_offset)
        countryOffset2 = resources.getDimensionPixelSize(R.dimen.card_width)

        vb.tvCountry1.x = countryOffset1.toFloat()
        vb.tvCountry2.x = countryOffset2.toFloat()
        vb.tvCountry1.text = houseModelArrayList!![0].name
        vb.tvCountry2.alpha = 0f

        vb.tvCountry1.typeface = Typeface.createFromAsset(activity!!.assets, "open-sans-extrabold.ttf")
        vb.tvCountry2.typeface = Typeface.createFromAsset(activity!!.assets, "open-sans-extrabold.ttf")
    }

    private fun setCountryText(text: String, left2right: Boolean) {
        val invisibleText: TextView
        val visibleText: TextView
        if (vb.tvCountry1.alpha > vb.tvCountry2.alpha) {
            visibleText = vb.tvCountry1
            invisibleText = vb.tvCountry2
        } else {
            visibleText = vb.tvCountry2
            invisibleText = vb.tvCountry1
        }

        val vOffset: Int
        if (left2right) {
            invisibleText.x = 0f
            vOffset = countryOffset2
        } else {
            invisibleText.x = countryOffset2.toFloat()
            vOffset = 0
        }

        invisibleText.text = text

        val iAlpha = ObjectAnimator.ofFloat(invisibleText, "alpha", 1f)
        val vAlpha = ObjectAnimator.ofFloat(visibleText, "alpha", 0f)
        val iX = ObjectAnimator.ofFloat(invisibleText, "x", countryOffset1 + 0f)
        val vX = ObjectAnimator.ofFloat(visibleText, "x", vOffset + 0f)

        val animSet = AnimatorSet()
        animSet.playTogether(iAlpha, vAlpha, iX, vX)
        animSet.duration = countryAnimDuration
        animSet.start()
    }

    private fun onActiveCardChange() {
        val pos = layoutManger!!.activeCardPosition
        if (pos == RecyclerView.NO_POSITION || pos == currentPosition) {
            return
        }

        onActiveCardChange(pos)
    }

    private fun onActiveCardChange(pos: Int) {
        val animH = intArrayOf(
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )
        val animV = intArrayOf(
            R.anim.slide_in_top,
            R.anim.slide_out_bottom
        )

        val left2right = pos < currentPosition
        if (left2right) {
            animH[0] = R.anim.slide_in_left
            animH[1] = R.anim.slide_out_right

            animV[0] = R.anim.slide_in_bottom
            animV[1] = R.anim.slide_out_top
        }

        setCountryText(houseModelArrayList!!.get(pos % houseModelArrayList!!.size).name!!, left2right)

        vb.tsTemperature.setInAnimation(activity, animH[0])
        vb.tsTemperature.setOutAnimation(activity, animH[1])
        vb.tsTemperature.setText(houseModelArrayList!![pos % houseModelArrayList!!.size].temperature)

        vb.tsPlace.setInAnimation(activity, animV[0])
        vb.tsPlace.setOutAnimation(activity, animV[1])
        vb.tsPlace.setText(houseModelArrayList!![pos % houseModelArrayList!!.size].place)

        vb.tsClock.setInAnimation(activity, animV[0])
        vb.tsClock.setOutAnimation(activity, animV[1])
        vb.tsClock.setText(houseModelArrayList!![pos % houseModelArrayList!!.size].time)

        vb.tsDescription.setText(houseModelArrayList!![pos % houseModelArrayList!!.size].descriptions)

        currentPosition = pos
    }

    private inner class TextViewFactory internal constructor(
        @param:StyleRes @field:StyleRes
        internal val styleId: Int, internal val center: Boolean
    ) : ViewSwitcher.ViewFactory {

        override fun makeView(): View {
            val textView = TextView(activity)

            if (center) {
                textView.gravity = Gravity.CENTER
            }

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                textView.setTextAppearance(activity, styleId)
            } else {
                textView.setTextAppearance(styleId)
            }

            return textView
        }

    }

    private inner class OnCardClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            val lm = vb.recyclerView.layoutManager as CardSliderLayoutManager?

            if (lm!!.isSmoothScrolling) {
                return
            }

            val activeCardPosition = lm.activeCardPosition
            if (activeCardPosition == RecyclerView.NO_POSITION) {
                return
            }

            val clickedPosition = vb.recyclerView.getChildAdapterPosition(view)
            if (clickedPosition == activeCardPosition) {
            } else if (clickedPosition > activeCardPosition) {
                vb.recyclerView.smoothScrollToPosition(clickedPosition)
                onActiveCardChange(clickedPosition)
            }
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }


    override fun onStop() {
        super.onStop()

    }


}
