package io.github.maikotrindade.animationsamples.ui

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.ViewPropertyAnimator
import androidx.fragment.app.Fragment
import androidx.transition.Transition
import io.github.maikotrindade.animationsamples.R

abstract class BaseFragment : Fragment() {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_reload, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_reload -> reloadFragment()
        }
        return super.onOptionsItemSelected(item)
    }

    protected fun addLogger(tag: String, animator: ViewPropertyAnimator) {
        animator.setListener(object: Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
                Log.d(tag, "onAnimationRepeat")            }

            override fun onAnimationEnd(p0: Animator?) {
                Log.d(tag, "onAnimationEnd")            }

            override fun onAnimationCancel(p0: Animator?) {
                Log.d(tag, "onAnimationCancel")            }

            override fun onAnimationStart(p0: Animator?) {
                Log.d(tag, "onAnimationStart")
            }
        })
    }

    protected fun addLogger(tag: String, objectAnimator: ObjectAnimator) {
        objectAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animator: Animator) {
                Log.d(tag, "onAnimationRepeat")
            }

            override fun onAnimationEnd(animator: Animator) {
                Log.d(tag, "onAnimationEnd")
            }

            override fun onAnimationCancel(animator: Animator) {
                Log.d(tag, "onAnimationCancel")
            }

            override fun onAnimationStart(animator: Animator) {
                Log.d(tag, "onAnimationStart")
            }
        })
    }

    protected fun addLogger(tag: String, animatorSet: AnimatorSet) {
        animatorSet.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animator: Animator) {
                Log.d(tag, "onAnimationRepeat")
            }
            override fun onAnimationEnd(animator: Animator) {
                Log.d(tag, "onAnimationEnd")
            }
            override fun onAnimationCancel(animator: Animator) {
                Log.d(tag, "onAnimationCancel")
            }
            override fun onAnimationStart(animator: Animator) {
                Log.d(tag, "onAnimationStart")
            }
        })
    }

    protected fun addLogger(tag: String, transition: Transition) {
        transition.addListener(object: Transition.TransitionListener {
            override fun onTransitionEnd(transition: Transition) {
                Log.d(tag, "onTransitionEnd")
            }

            override fun onTransitionResume(transition: Transition) {
                Log.d(tag, "onTransitionResume")
            }

            override fun onTransitionPause(transition: Transition) {
                Log.d(tag, "onTransitionPause")
            }

            override fun onTransitionCancel(transition: Transition) {
                Log.d(tag, "onTransitionCancel")
            }

            override fun onTransitionStart(transition: Transition) {
                Log.d(tag, "onTransitionStart")
            }
        })
    }

    abstract fun reloadFragment()
}