package io.github.maikotrindade.animationsamples.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.maikotrindade.animationsamples.R
import io.github.maikotrindade.animationsamples.home.vo.Screen
import kotlinx.android.synthetic.main.item_main_list.view.*

class MainListAdapter(private val items: List<Screen>, private val output: MainListOutput) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main_list, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val screen = items[position]
        holder.tvTitle.text = screen.title
        holder.itemView.setOnClickListener {
            output.onItemSelected(screen.navAction)
        }
    }
}

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle = view.tv_title!!
}

interface MainListOutput {
    fun onItemSelected(navAction: Int)
}