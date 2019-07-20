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
import androidx.lifecycle.Observer
import com.megathon.smarthome.BR.viewModel
import com.megathon.smarthome.R
import com.megathon.smarthome.SmartHomeBaseActivity
import com.megathon.smarthome.databinding.ActivitySigninBinding
import com.megathon.smarthome.ui.home.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : SmartHomeBaseActivity<ActivitySigninBinding>() {
    override fun layoutId(): Int = R.layout.activity_signin

    private val animDuration: Long = 500
    private val animRepeat: Int = 0
    private val transValue: Float = 1000f
    private val transValueStart: Float = 1f
    private val transValueEnd: Float = 0f
    private val loginViewModel by viewModel<SigninViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb.viewModel = loginViewModel
        vb.idTittle.text = "Login"
        vb.tvForgetpass.text = "Forget Password ?"

        vb.tvForgetpass.setOnClickListener() {
            if (vb.idTittle.text.equals("Login"))
                signinGoing() else
                forgetPasswordGoing()

        }
        signinComing()

        vb.floatingActionButton.setOnClickListener() {
            vb.progressBar.visibility = View.VISIBLE
            loginViewModel.getLoginDetails("satyamnaik15@gmail.com", "id", "password").observe(this, Observer {
                val intent = (Intent(this@LoginActivity, MainActivity::class.java))
                val options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this,
                        vb.floatingActionButton, // Starting view
                        "demo"    // The String
                    )
                vb.progressBar.visibility = View.GONE
                ActivityCompat.startActivity(this, intent, options.toBundle())
                finish()
            })

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
                forgetPasswordComing()
            }

            override fun onAnimationCancel(animation: Animator) {
                // ...
            }
        })

    }

    private fun forgetPasswordComing() {

        vb.idTittle.text = "Forget Password"
        vb.tvForgetpass.text = "Login"
        vb.floatingActionButton.show()

        vb.etRePassword.visibility = View.VISIBLE
        vb.linView.visibility = View.VISIBLE
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

    private fun forgetPasswordGoing() {

        vb.etRePassword.visibility = View.VISIBLE
        vb.linView.visibility = View.VISIBLE

        val linearLayoutAnimOut = ObjectAnimator.ofFloat(vb.linearLayout, "translationX", -transValue)
        linearLayoutAnimOut.repeatCount = animRepeat
        linearLayoutAnimOut.duration = animDuration

        val tvRegAnimOut = ObjectAnimator.ofFloat(vb.tvForgetpass, "translationX", transValue)
        tvRegAnimOut.repeatCount = animRepeat
        tvRegAnimOut.duration = animDuration
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
        val idTitleAnimshow = ObjectAnimator.ofFloat(vb.idTittle, "alpha", transValueEnd, transValueStart)
        idTitleAnimshow.repeatCount = animRepeat
        idTitleAnimshow.duration = animDuration
        val set = AnimatorSet()
        set.play(tvRegAnimIn).with(idTitleAnimshow).with(linearLayoutAnimIn)
        set.start()
    }

}

