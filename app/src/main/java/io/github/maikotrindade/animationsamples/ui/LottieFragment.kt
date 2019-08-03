package io.github.maikotrindade.animationsamples.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import io.github.maikotrindade.animationsamples.R

class LottieFragment : BaseFragment() {

    private val TAG = LottieFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_lottie, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    override fun reloadFragment() {
        Toast.makeText(requireContext(), getString(R.string.reload_screen), Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
        findNavController().navigate(R.id.lottieFragment)
    }

    private fun setupUI() {
        
    }
}
