package com.dzak.puasa.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dzak.puasa.databinding.ItemKategoriPuasaBinding
import com.dzak.puasa.model.PuasaItem

class PuasaViewHolder (val puasabinding : ItemKategoriPuasaBinding) : RecyclerView.ViewHolder(puasabinding.root){
    @SuppressLint("NotifyDataSetChanged")
    fun bind(puitem : PuasaItem){
        val adapterPuasaItem = BatalPuasaAdapter()
        itemView.run {
            puasabinding.tvpuasa.text = puitem.title
            puasabinding.recpuasa.setHasFixedSize(true)
            puasabinding.recpuasa.layoutManager = LinearLayoutManager(context)
            puasabinding.recpuasa.adapter = adapterPuasaItem
        }
        adapterPuasaItem.addData(puitem.data)
        adapterPuasaItem.notifyDataSetChanged()

    }
        }
