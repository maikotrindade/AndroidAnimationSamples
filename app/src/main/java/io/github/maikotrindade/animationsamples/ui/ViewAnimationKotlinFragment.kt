package io.github.maikotrindade.animationsamples.ui

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import io.github.maikotrindade.animationsamples.R
import kotlinx.android.synthetic.main.fragment_view_animation_kotlin.*

class ViewAnimationKotlinFragment : BaseFragment() {

    private val TAG = ViewAnimationKotlinFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_view_animation_kotlin, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    override fun reloadFragment() {
        Toast.makeText(requireContext(), getString(R.string.reload_screen), Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
        findNavController().navigate(R.id.viewAnimKotlinFragment)
    }

    private fun setupUI() {
        btn_animate.setOnClickListener {
            img_animation.animate()
                .setDuration(3000L)
                .scaleX(2F)
                .scaleY(2F)
                .rotationX(360F)
                .rotationY(360F)
                .translationX(150F)
                .setListener(object: Animator.AnimatorListener {
                    override fun onAnimationRepeat(p0: Animator?) {
                        Log.d(TAG, "onAnimationRepeat")
                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        Log.d(TAG, "onAnimationEnd")
                    }

                    override fun onAnimationCancel(p0: Animator?) {
                        Log.d(TAG, "onAnimationCancel")
                    }

                    override fun onAnimationStart(p0: Animator?) {
                        Log.d(TAG, "onAnimationStart")
                    }
                })
        }

    }
}
