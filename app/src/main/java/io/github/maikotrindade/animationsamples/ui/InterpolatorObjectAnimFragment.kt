package io.github.maikotrindade.animationsamples.ui

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.navigation.fragment.findNavController
import io.github.maikotrindade.animationsamples.R
import kotlinx.android.synthetic.main.fragment_interpolator_object_anim.*

class InterpolatorObjectAnimFragment : BaseFragment() {

    private val TAG = InterpolatorObjectAnimFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_interpolator_object_anim, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    override fun reloadFragment() {
        Toast.makeText(requireContext(), getString(R.string.reload_screen), Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
        findNavController().navigate(R.id.interpolatorObjectAnimFragment)
    }

    private fun setupUI() {

        btn_1.setOnClickListener {
            val targetY =  (container_view.height - img_animation.height).toFloat()
            ObjectAnimator.ofFloat(img_animation, "y", 0F, targetY).apply {
                duration = 900
                addLogger(this)
                interpolator = BounceInterpolator()
                start()
            }
        }

        btn_2.setOnClickListener {
            val targetY =  (container_view.height - img_animation.height).toFloat()
            ObjectAnimator.ofFloat(img_animation, "y", 0F, targetY).apply {
                duration = 900
                addLogger(this)
                interpolator = FastOutSlowInInterpolator()
                start()
            }
        }

        btn_3.setOnClickListener {
            val targetY =  (container_view.height - img_animation.height).toFloat()
            ObjectAnimator.ofFloat(img_animation, "y", 0F, targetY).apply {
                duration = 900
                addLogger(this)
                interpolator = OvershootInterpolator()
                start()
            }
        }

        btn_4.setOnClickListener {
            val targetY =  (container_view.height - img_animation.height).toFloat()
            ObjectAnimator.ofFloat(img_animation, "y", 0F, targetY).apply {
                duration = 900
                addLogger(this)
                interpolator = AccelerateInterpolator()
                start()
            }
        }

    }


    private fun addLogger(objectAnimator: ObjectAnimator) {
        objectAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animator: Animator) {
                Log.d(TAG, "onAnimationRepeat")
            }

            override fun onAnimationEnd(animator: Animator) {
                Log.d(TAG, "onAnimationEnd")
            }

            override fun onAnimationCancel(animator: Animator) {
                Log.d(TAG, "onAnimationCancel")
            }

            override fun onAnimationStart(animator: Animator) {
                Log.d(TAG, "onAnimationStart")
            }
        })
    }

}
