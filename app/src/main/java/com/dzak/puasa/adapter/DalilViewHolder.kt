package com.dzak.puasa.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.dzak.puasa.databinding.ItemRecyclerDalilBinding
import com.dzak.puasa.model.DalilPuasaItem

class DalilViewHolder(val dalilpuasabinding : ItemRecyclerDalilBinding) : RecyclerView.ViewHolder(dalilpuasabinding.root) {

    fun bind(lilitem : DalilPuasaItem){
        itemView.run {
            dalilpuasabinding.tvJuduldalil.text = lilitem.judul
            dalilpuasabinding.tvDeskdalil.text = lilitem.deskripsi
            Glide.with(this).load(lilitem.gambar).into(dalilpuasabinding.imgDalil)
//            dalilpuasabinding.imgDalil.load(lilitem.gambar)
        }
    }

}
