package io.github.maikotrindade.animationsamples.home

import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.maikotrindade.animationsamples.home.vo.Screen
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), MainListOutput {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(io.github.maikotrindade.animationsamples.R.layout.fragment_home, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    private fun setupUI() {
        animateScreen()
        rv_fragments.layoutManager = LinearLayoutManager(context)
        val listAdapter = MainListAdapter(getScreenList(), this)
        rv_fragments.adapter = listAdapter
    }

    private fun animateScreen() {
        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = 18000L
        val hsv = FloatArray(3)
        var runColor: Int
        hsv[1] = 1f
        hsv[2] = 1f
        animator.addUpdateListener { animation ->
            hsv[0] = 360 * animation.animatedFraction
            runColor = Color.HSVToColor(hsv)
            container?.setBackgroundColor(runColor)
        }
        animator.repeatCount = Animation.INFINITE
        animator.start()
    }

    private fun getScreenList() =
        listOf(
            Screen(getString(io.github.maikotrindade.animationsamples.R.string.title_view_anim_xml), io.github.maikotrindade.animationsamples.R.id.action_viewAnimFragment),
            Screen(getString(io.github.maikotrindade.animationsamples.R.string.title_view_anim_kotlin), io.github.maikotrindade.animationsamples.R.id.action_viewAnimKotlinFragment),
            Screen(getString(io.github.maikotrindade.animationsamples.R.string.title_frame_anim), io.github.maikotrindade.animationsamples.R.id.action_frameAnimFragment),
            Screen(getString(io.github.maikotrindade.animationsamples.R.string.title_object_animator), io.github.maikotrindade.animationsamples.R.id.action_objectAnimatorFragment),
            Screen(getString(io.github.maikotrindade.animationsamples.R.string.title_interpolator_object_animator), io.github.maikotrindade.animationsamples.R.id.action_interpolatorObjAnimFragment),
            Screen(getString(io.github.maikotrindade.animationsamples.R.string.title_transition_shared_elements), io.github.maikotrindade.animationsamples.R.id.action_transitionSharedFragment),
            Screen(getString(io.github.maikotrindade.animationsamples.R.string.title_transition_scenes), io.github.maikotrindade.animationsamples.R.id.action_transitionSceneFragment),
            Screen(getString(io.github.maikotrindade.animationsamples.R.string.title_lottie), io.github.maikotrindade.animationsamples.R.id.lottieFragment)
        )

    override fun onItemSelected(navAction: Int) {
        findNavController().navigate(navAction)
    }
}
