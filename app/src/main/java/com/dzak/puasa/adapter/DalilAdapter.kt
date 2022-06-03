package com.dzak.puasa.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzak.puasa.databinding.ItemRecyclerDalilBinding
import com.dzak.puasa.model.DalilPuasaItem

class DalilAdapter : RecyclerView.Adapter<DalilViewHolder>(){

    private var listdalilitem = arrayListOf<DalilPuasaItem>()
    fun addData(itemsdalil : List<DalilPuasaItem>) {
        listdalilitem.addAll(itemsdalil)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DalilViewHolder {
        val listitemdalilpuasabinding = ItemRecyclerDalilBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DalilViewHolder(listitemdalilpuasabinding)
    }

    override fun onBindViewHolder(holder: DalilViewHolder, position: Int) {
        val data = listdalilitem[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
       return listdalilitem.size
    }
}