package com.dzak.puasa.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.puasa.R
import com.dzak.puasa.adapter.BatalPuasaAdapter
import com.dzak.puasa.adapter.PuasaAdapter
import com.dzak.puasa.databinding.FragmentBatalPuasaBinding
import com.dzak.puasa.databinding.FragmentPuasaBinding
import com.dzak.puasa.model.BatalPuasaItem
import com.dzak.puasa.model.PuasaItem
import com.dzak.puasa.network.RetrofitService
import com.dzak.puasa.network.Retrofitinterface
import com.dzak.puasa.room.RoomDB
import kotlinx.coroutines.launch


class BatalPuasaFragment : Fragment() {

    private lateinit var binding: FragmentBatalPuasaBinding
    private lateinit var adapterBatalPuasa: BatalPuasaAdapter

    private lateinit var roomDB: RoomDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBatalPuasaBinding.inflate(inflater, container, false)

        roomDB = context?.let { RoomDB.getRoomDatabaseItem(it) }!!

        adapterBatalPuasa = BatalPuasaAdapter()
        binding.recyclerBatal.adapter = adapterBatalPuasa
        binding.recyclerBatal.setHasFixedSize(true)
        binding.recyclerBatal.layoutManager = LinearLayoutManager(context)

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataitemBatalPuasa = roomDB.roomDao().getDatabyType("BatalPuasa")

        dataitemBatalPuasa.observe(viewLifecycleOwner, Observer {
            Log.e("Banyanknya data", it.size.toString())
            if (it.isNotEmpty()) {
                adapterBatalPuasa.addData(it)
                adapterBatalPuasa.notifyDataSetChanged()
            } else {
                Toast.makeText(context, "Database kosong", Toast.LENGTH_SHORT).show()
                val retrofitService = RetrofitService.buildservice(Retrofitinterface::class.java)

                viewLifecycleOwner.lifecycleScope.launch {
                    val mintadatabatalpuasa = retrofitService.getDatabatalpuasa()
                    if (mintadatabatalpuasa.isSuccessful) {
                        val dataBatalPuasa = mintadatabatalpuasa.body() as List<BatalPuasaItem>
                        dataBatalPuasa.forEach {
                            it.type = "BatalPuasa"
                        }
                        roomDB.roomDao().insertData(dataBatalPuasa)
                    }
                }
            }

        })


    }
}
