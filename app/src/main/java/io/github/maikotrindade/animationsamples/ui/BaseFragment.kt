package io.github.maikotrindade.animationsamples.ui

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
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

    abstract fun reloadFragment()
}