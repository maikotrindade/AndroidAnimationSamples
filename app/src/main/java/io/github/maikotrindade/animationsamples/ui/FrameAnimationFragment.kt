package io.github.maikotrindade.animationsamples.ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import io.github.maikotrindade.animationsamples.R
import kotlinx.android.synthetic.main.fragment_frame_animation.*

class FrameAnimationFragment : BaseFragment() {

    private var animation: AnimationDrawable? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_frame_animation, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    override fun reloadFragment() {
        Toast.makeText(requireContext(), getString(R.string.reload_screen), Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
        findNavController().navigate(R.id.frameAnimFragment)
    }

    private fun setupUI() {

        img_smile?.let {
            it.visibility - View.INVISIBLE
            it.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.animation_frame))
            animation = img_smile.drawable as AnimationDrawable
        }

        btn_start.setOnClickListener {
            img_smile.visibility - View.VISIBLE
            animation?.let {
                if (it.isRunning) {
                    it.stop()
                }
                it.start()
            }
        }

        btn_stop.setOnClickListener {
            animation?.let {
                it.stop()
            }
        }

    }
}
