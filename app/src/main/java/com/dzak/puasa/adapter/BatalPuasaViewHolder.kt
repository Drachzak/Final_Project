package com.dzak.puasa.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.dzak.puasa.databinding.ItemRecyclerBinding
import com.dzak.puasa.model.BatalPuasaItem

class BatalPuasaViewHolder(val batalpuasabinding : ItemRecyclerBinding) : RecyclerView.ViewHolder(batalpuasabinding.root) {
    fun bindView(item : BatalPuasaItem){
        itemView.run {
            batalpuasabinding.tvJudulpuasa.text = item.judul
            batalpuasabinding.tvDeskpuasa.text = item.desk
            Glide.with(this).load(item.gambar).into(batalpuasabinding.imgPuasa)
//            batalpuasabinding.imgPuasa.load(item.gambar)
        }
    }

}
