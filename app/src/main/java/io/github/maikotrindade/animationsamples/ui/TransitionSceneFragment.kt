package io.github.maikotrindade.animationsamples.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.transition.Explode
import androidx.transition.Fade
import androidx.transition.Scene
import androidx.transition.TransitionManager
import io.github.maikotrindade.animationsamples.R
import kotlinx.android.synthetic.main.fragment_transition_scene.*
import kotlinx.android.synthetic.main.fragment_view_animation.btn_animate

class TransitionSceneFragment : BaseFragment() {

    private val TAG = TransitionSceneFragment::class.java.simpleName
    private var currentScene = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_transition_scene, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    override fun reloadFragment() {
        Toast.makeText(requireContext(), getString(R.string.reload_screen), Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
        findNavController().navigate(R.id.transitionSceneFragment)
    }

    private fun setupUI() {
        val scene1: Scene = Scene.getSceneForLayout(container_scene, R.layout.scene_android, requireContext())
        val scene2: Scene = Scene.getSceneForLayout(container_scene, R.layout.scene_boom, requireContext())

        val explodeTransition = Explode()
        val fadeTransition = Fade()

        btn_animate.setOnClickListener {
            currentScene = if (currentScene == 1) {
                TransitionManager.go(scene2, explodeTransition)
                2
            } else {
                TransitionManager.go(scene1, fadeTransition)
                1
            }
        }
    }
}
