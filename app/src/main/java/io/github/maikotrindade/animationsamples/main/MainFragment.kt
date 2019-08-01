package io.github.maikotrindade.animationsamples.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.maikotrindade.animationsamples.R
import io.github.maikotrindade.animationsamples.main.vo.Screen
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainListOutput {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    private fun setupUI() {
        val screen1 = Screen(R.id.screen, getString(R.string.title_view_anim_xml), R.id.action_viewAnimFragment)

        val listOfScreens = listOf(screen1)
        rv_fragments.layoutManager = LinearLayoutManager(context)
        val listAdapter = MainListAdapter(listOfScreens, this)
        rv_fragments.adapter = listAdapter
    }

    override fun onItemSelected(navAction: Int) {
        findNavController().navigate(navAction)
    }

}
