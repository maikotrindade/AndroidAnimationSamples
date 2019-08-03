package io.github.maikotrindade.animationsamples.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import io.github.maikotrindade.animationsamples.R
import kotlinx.android.synthetic.main.fragment_transition_shared_elements.*

class TransitionSharedElementsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_transition_shared_elements, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    override fun reloadFragment() {
        Toast.makeText(requireContext(), getString(R.string.reload_screen), Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
        findNavController().navigate(R.id.transitionSharedFragment)
    }

    private fun setupUI() {
        btn_next.setOnClickListener {
            val extras = FragmentNavigatorExtras(img_animation to "image", txt_title to "title")
            findNavController().navigate(R.id.action_transitionDetailsFragment, null, null, extras)
        }
    }
}
