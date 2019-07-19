package com.megathon.smarthome.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.megathon.smarthome.R
import com.megathon.smarthome.ui.home.view.HomeFragment
import com.megathon.smarthome.utility.Constant.Companion.HOME_TITLE
import test.cyron.nmschool.nmschool.utility.FragmentHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setHome()
    }

    fun setHome() {
        FragmentHelper.clearBackStack(this)
        val fragment = HomeFragment()
        FragmentHelper.replaceFragment(this@MainActivity, R.id.home_container, fragment, true, HOME_TITLE)

    }
}
