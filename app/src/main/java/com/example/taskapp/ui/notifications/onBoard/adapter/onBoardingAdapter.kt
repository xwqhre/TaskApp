package com.example.taskapp.ui.notifications.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp.adapter.utils.loadImage
import com.example.taskapp.databinding.ItemOnBoardingBinding
import com.example.taskapp.model.onBoard

class onBoardingAdapter(private val onClick:(onBoard) -> Unit) :    //в конструкторе можно передавать еще и методы
Adapter<onBoardingAdapter.onBoardingViewHolder>() {
    private val data = arrayListOf(
        onBoard(title = "Title 1 ", desc = "Desc 1", image = "https://cdn-icons-png.flaticon.com/512/2098/2098402.png "),
        onBoard(title = "Title 2 ", desc = "Desc 2", image = "https://cdn-icons-png.flaticon.com/512/2098/2098402.png "),
        onBoard(title = "Title 3 ", desc = "Desc 3", image = "https://cdn-icons-png.flaticon.com/512/2098/2098402.png  "))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingViewHolder {
        return onBoardingViewHolder(ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: onBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
        holder.itemView.setOnClickListener{
            onClick(onBoard())//invoke более безопасный метод
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class onBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard:onBoard) {
            binding.btnStart.setOnClickListener{
        onClick(onBoard)
            }
            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.desc
            binding.ivBoard.loadImage(onBoard.image)

        }
    }
}