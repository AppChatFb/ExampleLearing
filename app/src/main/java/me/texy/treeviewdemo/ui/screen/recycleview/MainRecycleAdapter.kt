package me.texy.treeviewdemo.ui.screen.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.texy.treeviewdemo.databinding.ItemRecycleBinding

class MainRecycleAdapter(val itemClickListener: (item: Int, item2: Int) -> Unit = { item, item2 -> {} }) : ListAdapter<Item, MainRecycleAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
) {

    class ViewHolder(itemBinding: ItemRecycleBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val binding = itemBinding

        fun onBind(item: Item) {
            binding.tvName.text = item.name
            binding.tvAddress.text = item.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecycleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
        holder.itemView.setOnClickListener {
            itemClickListener(position,position)
        }
    }

    override fun submitList(list: MutableList<Item>?) {
        super.submitList(list)
    }
}