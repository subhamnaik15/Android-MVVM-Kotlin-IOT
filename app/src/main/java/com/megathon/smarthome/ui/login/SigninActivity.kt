package com.megathon.smarthome.ui.login

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat

import com.megathon.smarthome.R
import com.megathon.smarthome.SmartHomeBaseActivity
import com.megathon.smarthome.databinding.ActivitySigninBinding
import com.megathon.smarthome.ui.home.MainActivity


class SigninActivity : SmartHomeBaseActivity<ActivitySigninBinding>() {
    override fun layoutId(): Int = R.layout.activity_signin

    private val animDuration: Long = 500
    private val animRepeat: Int = 0
    private val transValue: Float = 1000f
    private val transValueStart: Float = 1f
    private val transValueEnd: Float = 0f
    private lateinit var signinViewmodel: SigninViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signinViewmodel = SigninViewmodel()

        vb.idTittle.text = "Login"
        vb.tvForgetpass.text = "Forget Password ?"

        vb.tvForgetpass.setOnClickListener() {
            if (vb.idTittle.text.equals("Login"))
                signinGoing() else
                ForgetpassGoing()

        }
        signinComing()

        vb.floatingActionButton.setOnClickListener() {

//            vb.loder.setAnimation("raw/loder1.json")
//            vb.loder.repeatCount= LottieDrawable.INFINITE
//            vb.loder.playAnimation()

//            signinViewmodel.signin("satyamnaik15@gmail.com", "id", "password")
            val intent = (Intent(this@SigninActivity, MainActivity::class.java))
            val options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    vb.floatingActionButton, // Starting view
                    "demo"    // The String
                )
            ActivityCompat.startActivity(this, intent, options.toBundle())
            finish()
        }


    }

    private fun signinGoing() {

        vb.etRePassword.visibility = View.GONE
        vb.linView.visibility = View.GONE

        val linearLayoutAnimOut = ObjectAnimator.ofFloat(vb.linearLayout, "translationX", -transValue)
        linearLayoutAnimOut.repeatCount = animRepeat
        linearLayoutAnimOut.duration = animDuration
        val tvRegAnimOut = ObjectAnimator.ofFloat(vb.tvForgetpass, "translationX", transValue)
        tvRegAnimOut.repeatCount = animRepeat
        tvRegAnimOut.duration = animDuration
//        val tvForgetAnimOut = ObjectAnimator.ofFloat(tvForget, "translationX", transValue)
//        tvForgetAnimOut.repeatCount = animRepeat
//        tvForgetAnimOut.duration = animDuration
        val idTitleAnimHide = ObjectAnimator.ofFloat(vb.idTittle, "alpha", transValueStart, transValueEnd)
        idTitleAnimHide.repeatCount = animRepeat
        idTitleAnimHide.duration = animDuration
        vb.floatingActionButton.hide()
        val set = AnimatorSet()
        set.play(tvRegAnimOut).with(idTitleAnimHide).with(linearLayoutAnimOut)
        set.start()

        set.addListener(object : AnimatorListener {

            override fun onAnimationStart(animation: Animator) {
                // ...
            }

            override fun onAnimationRepeat(animation: Animator) {
                // ...
            }

            override fun onAnimationEnd(animation: Animator) {
                ForgetpassComing()
            }

            override fun onAnimationCancel(animation: Animator) {
                // ...
            }
        })

    }

    private fun ForgetpassComing() {

        vb.idTittle.text = "Forget Password"
        vb.tvForgetpass.text = "Login"
        vb.floatingActionButton.show()

        vb.etRePassword.visibility = View.VISIBLE
        vb.linView.visibility = View.VISIBLE

//        val etEmailExpand = ObjectAnimator.ofFloat(etEmail, "translationY", 0f)
//        etEmailExpand.repeatCount = 0
//        etEmailExpand.duration = 1000

        val linearLayoutAnimIn = ObjectAnimator.ofFloat(vb.linearLayout, "translationX", transValueEnd)
        linearLayoutAnimIn.repeatCount = animRepeat
        linearLayoutAnimIn.duration = animDuration
        val tvRegAnimIn = ObjectAnimator.ofFloat(vb.tvForgetpass, "translationX", transValueEnd)
        tvRegAnimIn.repeatCount = animRepeat
        tvRegAnimIn.duration = animDuration
        val idTitleAnimshow = ObjectAnimator.ofFloat(vb.idTittle, "alpha", transValueEnd, transValueStart)
        idTitleAnimshow.repeatCount = animRepeat
        idTitleAnimshow.duration = animDuration
        val set = AnimatorSet()
        set.play(tvRegAnimIn).with(idTitleAnimshow).with(linearLayoutAnimIn)
        set.start()
    }

    private fun ForgetpassGoing() {

        vb.etRePassword.visibility = View.VISIBLE
        vb.linView.visibility = View.VISIBLE

        val linearLayoutAnimOut = ObjectAnimator.ofFloat(vb.linearLayout, "translationX", -transValue)
        linearLayoutAnimOut.repeatCount = animRepeat
        linearLayoutAnimOut.duration = animDuration

        val tvRegAnimOut = ObjectAnimator.ofFloat(vb.tvForgetpass, "translationX", transValue)
        tvRegAnimOut.repeatCount = animRepeat
        tvRegAnimOut.duration = animDuration
//        val tvForgetAnimOut = ObjectAnimator.ofFloat(tvForget, "translationX", transValue)
//        tvForgetAnimOut.repeatCount = animRepeat
//        tvForgetAnimOut.duration = animDuration
        val idTitleAnimHide = ObjectAnimator.ofFloat(vb.idTittle, "alpha", transValueStart, transValueEnd)
        idTitleAnimHide.repeatCount = animRepeat
        idTitleAnimHide.duration = animDuration
        vb.floatingActionButton.hide()
        val set = AnimatorSet()
        set.play(tvRegAnimOut).with(idTitleAnimHide).with(linearLayoutAnimOut)
        set.start()

        set.addListener(object : AnimatorListener {

            override fun onAnimationStart(animation: Animator) {
                // ...
            }

            override fun onAnimationRepeat(animation: Animator) {
                // ...
            }

            override fun onAnimationEnd(animation: Animator) {
                signinComing()

            }

            override fun onAnimationCancel(animation: Animator) {
                // ...
            }
        })
    }

    private fun signinComing() {
        vb.idTittle.text = "Login"
        vb.tvForgetpass.text = "Forget Password ?"
        vb.floatingActionButton.show()

        vb.etRePassword.visibility = View.GONE
        vb.linView.visibility = View.GONE

        val linearLayoutAnimIn = ObjectAnimator.ofFloat(vb.linearLayout, "translationX", transValueEnd)
        linearLayoutAnimIn.repeatCount = animRepeat
        linearLayoutAnimIn.duration = animDuration

        val tvRegAnimIn = ObjectAnimator.ofFloat(vb.tvForgetpass, "translationX", transValueEnd)
        tvRegAnimIn.repeatCount = animRepeat
        tvRegAnimIn.duration = animDuration
//        val tvForgetAnimIn = ObjectAnimator.ofFloat(tvForget, "translationX", transValueEnd)
//        tvForgetAnimIn.repeatCount = animRepeat
//        tvForgetAnimIn.duration = animDuration
        val idTitleAnimshow = ObjectAnimator.ofFloat(vb.idTittle, "alpha", transValueEnd, transValueStart)
        idTitleAnimshow.repeatCount = animRepeat
        idTitleAnimshow.duration = animDuration
        val set = AnimatorSet()
        set.play(tvRegAnimIn).with(idTitleAnimshow).with(linearLayoutAnimIn)
        set.start()
    }

}

