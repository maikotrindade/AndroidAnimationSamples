package io.github.maikotrindade.animationsamples.ui

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import io.github.maikotrindade.animationsamples.R
import kotlinx.android.synthetic.main.fragment_object_animator.*

class ObjectAnimatorFragment : BaseFragment() {

    private val TAG = ObjectAnimatorFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_object_animator, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    override fun reloadFragment() {
        Toast.makeText(requireContext(), getString(R.string.reload_screen), Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
        findNavController().navigate(R.id.objectAnimatorFragment)
    }

    private fun setupUI() {
        val animationX: ObjectAnimator = ObjectAnimator.ofFloat(img_animation, "scaleX", 1f, 2f).setDuration(2000L)
        val animationY: ObjectAnimator = ObjectAnimator.ofFloat(img_animation, "scaleY", 1f, 2f).setDuration(2000L)

        btn_playtogether.setOnClickListener {
            val animatorSet = AnimatorSet()
            addLogger(animatorSet)
            animatorSet.playTogether(animationY, animationX)
            animatorSet.start()
        }

        btn_playsequence.setOnClickListener {
            val animatorSet = AnimatorSet()
            addLogger(animatorSet)
            animatorSet.duration = 3000L
            animatorSet.playSequentially(animationY, animationX)
            animatorSet.start()
        }
    }
    
    private fun addLogger(AnimatorSet: AnimatorSet) {
        AnimatorSet.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animator: Animator) { Log.d(TAG, "onAnimationRepeat")}
            override fun onAnimationEnd(animator: Animator) {
                Log.d(TAG, "onAnimationEnd")}
            override fun onAnimationCancel(animator: Animator) {
                Log.d(TAG, "onAnimationCancel")}
            override fun onAnimationStart(animator: Animator) {
                Log.d(TAG, "onAnimationStart")}
        })
    }
}
