package me.texy.treeviewdemo.ui.screen.hone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.texy.treeviewdemo.R
import me.texy.treeviewdemo.data.model.Competition
import me.texy.treeviewdemo.data.model.CompetitionEntity
import me.texy.treeviewdemo.databinding.ItemCompetitionBinding

class CompetitionAdapter : ListAdapter<Competition, CompetitionAdapter.ComViewHolder>(object :
    DiffUtil.ItemCallback<Competition>() {
    override fun areItemsTheSame(oldItem: Competition, newItem: Competition): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Competition,
        newItem: Competition
    ): Boolean {
        return oldItem == newItem
    }
}) {
    open class ComViewHolder(binding: ItemCompetitionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemBinding = binding
        fun onBind(item: Competition) {
            itemBinding.competitionName.text = item.name
            itemBinding.competitionCountry.text = item.area.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        return ComViewHolder(
            DataBindingUtil.inflate(
                inflate,
                R.layout.item_competition,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ComViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

}