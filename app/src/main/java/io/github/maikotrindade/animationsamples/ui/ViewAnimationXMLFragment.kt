package io.github.maikotrindade.animationsamples.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import io.github.maikotrindade.animationsamples.R
import kotlinx.android.synthetic.main.fragment_view_animation.*

class ViewAnimationXMLFragment : BaseFragment() {

    private val TAG = ViewAnimationXMLFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_view_animation, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    override fun reloadFragment() {
        Toast.makeText(requireContext(), getString(R.string.reload_screen), Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
        findNavController().navigate(R.id.viewAnimFragment)
    }

    private fun setupUI() {
        btn_animate.setOnClickListener {
            val growAnimation = AnimationUtils.loadAnimation(this.requireContext(), R.anim.grow)

            growAnimation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {
                    Log.d(TAG, "onAnimationRepeat")
                }

                override fun onAnimationEnd(p0: Animation?) {
                    Log.d(TAG, "onAnimationEnd")
                    img_animation.scaleX = 2F
                    img_animation.scaleY = 2F
                }

                override fun onAnimationStart(p0: Animation?) {
                    Log.d(TAG, "onAnimationStart")
                }

            })
            img_animation.startAnimation(growAnimation)
        }
    }
}
