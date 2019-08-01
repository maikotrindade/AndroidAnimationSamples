package io.github.maikotrindade.animationsamples.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import io.github.maikotrindade.animationsamples.R
import kotlinx.android.synthetic.main.fragment_main.*

class ViewAnimationXMLFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_animation, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    private fun setupUI() {
        btn_animate.setOnClickListener {
            val growAnimation = AnimationUtils.loadAnimation(this.requireContext(), R.anim.grow)

            growAnimation.setAnimationListener(object: Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    img_smile.scaleX = 2F
                    img_smile.scaleY = 2F
                }

                override fun onAnimationStart(p0: Animation?) {
                }

            })
            img_smile.startAnimation(growAnimation)
        }
    }
}
