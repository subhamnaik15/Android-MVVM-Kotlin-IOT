package com.megathon.smarthome.ui.home.view.cardSlider

import android.view.View
import androidx.core.view.ViewCompat

/**
 * Default implementation of [CardSliderLayoutManager.ViewUpdater]
 */
class DefaultViewUpdater : CardSliderLayoutManager.ViewUpdater {

    private var cardWidth: Int = 0
    private var activeCardLeft: Int = 0
    private var activeCardRight: Int = 0
    private var activeCardCenter: Int = 0
    private var cardsGap: Float = 0.toFloat()

    private var transitionEnd: Int = 0
    private var transitionDistance: Int = 0
    private var transitionRight2Center: Float = 0.toFloat()

    private var lm: CardSliderLayoutManager? = null

    private var previewView: View? = null

    override fun onLayoutManagerInitialized(lm: CardSliderLayoutManager) {
        this.lm = lm

        this.cardWidth = lm.cardWidth
        this.activeCardLeft = lm.activeCardLeft
        this.activeCardRight = lm.activeCardRight
        this.activeCardCenter = lm.activeCardCenter
        this.cardsGap = lm.cardsGap

        this.transitionEnd = activeCardCenter
        this.transitionDistance = activeCardRight - transitionEnd

        val centerBorder = (cardWidth - cardWidth * SCALE_CENTER) / 2f
        val rightBorder = (cardWidth - cardWidth * SCALE_RIGHT) / 2f
        val right2centerDistance = activeCardRight + centerBorder - (activeCardRight - rightBorder)
        this.transitionRight2Center = right2centerDistance - cardsGap
    }

    override fun updateView(view: View, position: Float) {
        val scale: Float
        val alpha: Float
        val z: Float
        val x: Float

        if (position < 0) {
            val ratio = lm!!.getDecoratedLeft(view).toFloat() / activeCardLeft
            scale = SCALE_LEFT + SCALE_CENTER_TO_LEFT * ratio
            alpha = 0.1f + ratio
            z = Z_CENTER_1 * ratio
            x = 0f
        } else if (position < 0.5f) {
            scale = SCALE_CENTER
            alpha = 1f
            z = Z_CENTER_1.toFloat()
            x = 0f
        } else if (position < 1f) {
            val viewLeft = lm!!.getDecoratedLeft(view)
            val ratio = (viewLeft - activeCardCenter).toFloat() / (activeCardRight - activeCardCenter)
            scale = SCALE_CENTER - SCALE_CENTER_TO_RIGHT * ratio
            alpha = 1f
            z = Z_CENTER_2.toFloat()
            if (Math.abs(transitionRight2Center) < Math.abs(transitionRight2Center * (viewLeft - transitionEnd) / transitionDistance)) {
                x = -transitionRight2Center
            } else {
                x = -transitionRight2Center * (viewLeft - transitionEnd) / transitionDistance
            }
        } else {
            scale = SCALE_RIGHT
            alpha = 1f
            z = Z_RIGHT.toFloat()

            if (previewView != null) {
                val prevViewScale: Float
                val prevTransition: Float
                val prevRight: Int

                val isFirstRight = lm!!.getDecoratedRight(previewView!!) <= activeCardRight
                if (isFirstRight) {
                    prevViewScale = SCALE_CENTER
                    prevRight = activeCardRight
                    prevTransition = 0f
                } else {
                    prevViewScale = previewView!!.scaleX
                    prevRight = lm!!.getDecoratedRight(previewView!!)
                    prevTransition = previewView!!.translationX
                }

                val prevBorder = (cardWidth - cardWidth * prevViewScale) / 2
                val currentBorder = (cardWidth - cardWidth * SCALE_RIGHT) / 2
                val distance = lm!!.getDecoratedLeft(view) + currentBorder - (prevRight - prevBorder + prevTransition)

                val transition = distance - cardsGap
                x = -transition
            } else {
                x = 0f
            }
        }

        view.scaleX = scale
        view.scaleY = scale
        ViewCompat.setZ(view, z)
        view.translationX = x
        view.alpha = alpha

        previewView = view
    }

    companion object {

        val SCALE_LEFT = 0.65f
        val SCALE_CENTER = 0.95f
        val SCALE_RIGHT = 0.8f
        val SCALE_CENTER_TO_LEFT = SCALE_CENTER - SCALE_LEFT
        val SCALE_CENTER_TO_RIGHT = SCALE_CENTER - SCALE_RIGHT

        val Z_CENTER_1 = 12
        val Z_CENTER_2 = 16
        val Z_RIGHT = 8
    }

}
