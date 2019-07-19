package com.megathon.smarthome

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class SmartHomeBaseActivity<VB : ViewDataBinding> : AppCompatActivity() {
    lateinit var vb: VB

    @LayoutRes
    abstract fun layoutId(): Int

    override fun setContentView(layoutResID: Int) {
        vb = DataBindingUtil.inflate(layoutInflater, layoutResID, null, false)
        super.setContentView(vb.root)
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
    }
}