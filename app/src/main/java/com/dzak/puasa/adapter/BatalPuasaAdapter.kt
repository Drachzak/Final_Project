package com.dzak.puasa.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzak.puasa.DetailBatalActivity
import com.dzak.puasa.databinding.ItemRecyclerBinding
import com.dzak.puasa.model.BatalPuasaItem

class BatalPuasaAdapter : RecyclerView.Adapter<BatalPuasaViewHolder>() {

    private var listitembatalpuasa = arrayListOf<BatalPuasaItem>()
    fun addData(items: List<BatalPuasaItem>) {
        listitembatalpuasa.clear()
        listitembatalpuasa.addAll(items)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatalPuasaViewHolder {
        val listitembatalpuasabinding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BatalPuasaViewHolder(listitembatalpuasabinding)
    }

    override fun onBindViewHolder(holder: BatalPuasaViewHolder, position: Int) {
        val data = listitembatalpuasa[position]
        holder.bindView(data)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailBatalActivity::class.java)
            intent.putExtra(DetailBatalActivity.Detail_Data_Batal, data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listitembatalpuasa.size
    }

}
