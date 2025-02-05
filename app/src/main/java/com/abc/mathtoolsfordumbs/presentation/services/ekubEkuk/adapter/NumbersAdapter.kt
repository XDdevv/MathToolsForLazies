package com.abc.mathtoolsfordumbs.presentation.services.ekubEkuk.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abc.mathtoolsfordumbs.databinding.ItemEkubEkukNumberBinding

class NumbersAdapter : RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder>() {
    private val numbers = mutableListOf<Int>(0,0)

    fun addNumber(number: Int) {
        numbers.add(number)
        notifyItemInserted(numbers.size - 1)
    }

    fun  removeNumber(position: Int) {
        numbers.removeAt(position)
        notifyItemRemoved(position)
    }

    fun getNumbers(): List<Int> = numbers.toList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NumbersViewHolder {
        val binding = ItemEkubEkukNumberBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NumbersViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NumbersViewHolder,
        position: Int
    ) {
        holder.onBind(numbers[position])
    }

    override fun getItemCount(): Int = numbers.size

    inner class NumbersViewHolder(private val binding: ItemEkubEkukNumberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(number: Int) {

            if (numbers.size >= 2) {
                binding.deleteIv.isEnabled = true
            } else {
                binding.deleteIv.isEnabled = false
            }

            if (number != 0) {
                binding.numberEt.setText(number.toString())
            } else {
                binding.numberEt.setText("")
            }

            binding.deleteIv.setOnClickListener {
                if (numbers.size <= 2) {
                    binding.deleteIv.isEnabled = false
                } else {
                    removeNumber(adapterPosition)
                }
            }

            binding.numberEt.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                }

                override fun afterTextChanged(s: Editable?) {
                    val newNumber = s.toString().toIntOrNull() ?: 0
                    numbers[adapterPosition] = newNumber
                }

            })
        }
    }
}