package com.abc.mathtoolsfordumbs.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abc.mathtoolsfordumbs.databinding.ItemOptionsBinding
import com.abc.mathtoolsfordumbs.domain.model.app.Option

class OptionsAdapter(
    private val onItemClick: (Option) -> Unit
) : RecyclerView.Adapter<OptionsAdapter.OptionsViewHolder>() {

    private val list = mutableListOf<Option>()

    fun submitList(newList: List<Option>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OptionsViewHolder {
        return OptionsViewHolder(
            ItemOptionsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: OptionsViewHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class OptionsViewHolder(private val binding: ItemOptionsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Option) {
            binding.titleTv.text = item.title
            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }

    }
}