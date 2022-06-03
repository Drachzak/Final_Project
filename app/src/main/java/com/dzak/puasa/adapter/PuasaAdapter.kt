package com.dzak.puasa.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzak.puasa.DetailBatalActivity
import com.dzak.puasa.R
import com.dzak.puasa.databinding.ItemKategoriPuasaBinding
import com.dzak.puasa.databinding.ItemRecyclerBinding
import com.dzak.puasa.model.PuasaItem

class PuasaAdapter : RecyclerView.Adapter<PuasaViewHolder>() {


    private val listitempuasa = arrayListOf<PuasaItem>()
    fun addData(itempuasa: List<PuasaItem>) {
        listitempuasa.clear()
        listitempuasa.addAll(itempuasa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PuasaViewHolder {
        val itemkategoripuasabinding =
            ItemKategoriPuasaBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PuasaViewHolder(itemkategoripuasabinding)
    }

    override fun onBindViewHolder(holder: PuasaViewHolder, position: Int) {
        val data = listitempuasa[position]
        holder.bind(data)

//        holder.itemView.setOnClickListener {
//            val intent = Intent(it.context, DetailBatalActivity::class.java)
//            intent.putExtra(DetailBatalActivity)
        }

    override fun getItemCount(): Int {
        return listitempuasa.size
    }


}


