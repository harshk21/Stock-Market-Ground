package com.smg.stock_market_ground.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smg.stock_market_ground.databinding.HomeArenaListLayoutBinding
import com.smg.stock_market_ground.model.HomeArenaModel

class HomeAdapter(private val arenaList: List<HomeArenaModel>): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    private lateinit var homeArenaListLayoutBinding: HomeArenaListLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        homeArenaListLayoutBinding = HomeArenaListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(homeArenaListLayoutBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(arenaList[position])
    }

    override fun getItemCount(): Int {
        return arenaList.size
    }

    class MyViewHolder(var homeArenaListLayoutBinding: HomeArenaListLayoutBinding): RecyclerView.ViewHolder(homeArenaListLayoutBinding.root) {
        fun bind(item: HomeArenaModel){
            homeArenaListLayoutBinding.tvPrizeView.text = item.arenaPrize
            homeArenaListLayoutBinding.tvEntryView.text = item.entry
            homeArenaListLayoutBinding.tvTitle.text = item.type
        }

    }
}