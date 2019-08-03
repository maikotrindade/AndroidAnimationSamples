package io.github.maikotrindade.animationsamples.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.maikotrindade.animationsamples.R
import io.github.maikotrindade.animationsamples.home.vo.Screen
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), MainListOutput {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    private fun setupUI() {
        rv_fragments.layoutManager = LinearLayoutManager(context)
        val listAdapter = MainListAdapter(getScreenList(), this)
        rv_fragments.adapter = listAdapter
    }

    private fun getScreenList() =
        listOf(
            Screen(getString(R.string.title_view_anim_xml), R.id.action_viewAnimFragment),
            Screen(getString(R.string.title_view_anim_kotlin), R.id.action_viewAnimKotlinFragment),
            Screen(getString(R.string.title_frame_anim), R.id.action_frameAnimFragment),
            Screen(getString(R.string.title_object_animator), R.id.action_objectAnimatorFragment),
            Screen(getString(R.string.title_interpolator_object_animator), R.id.action_interpolatorObjAnimFragment),
            Screen(getString(R.string.title_transition_shared_elements), R.id.action_transitionSharedFragment),
            Screen(getString(R.string.title_transition_scenes), R.id.action_transitionSceneFragment),
            Screen(getString(R.string.title_lottie), R.id.lottieFragment)
        )

    override fun onItemSelected(navAction: Int) {
        findNavController().navigate(navAction)
    }
}
