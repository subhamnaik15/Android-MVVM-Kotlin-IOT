package com.megathon.smarthome

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class SmartHomeBaseFragment <VB : ViewDataBinding> : Fragment() {
    lateinit var vb: VB

    @LayoutRes
    abstract fun layoutId(): Int

    fun setContentView(layoutResID: Int) {
        vb = DataBindingUtil.inflate(layoutInflater, layoutResID, null, false)
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
    }
}