package com.dzak.puasa.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.puasa.R
import com.dzak.puasa.adapter.PuasaAdapter
import com.dzak.puasa.databinding.FragmentPuasaBinding
import com.dzak.puasa.model.PuasaItem
import com.dzak.puasa.network.RetrofitService
import com.dzak.puasa.network.Retrofitinterface
import kotlinx.coroutines.launch


class FragmentPuasa : Fragment() {

    private lateinit var binding : FragmentPuasaBinding
    private lateinit var adapterPuasa: PuasaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPuasaBinding.inflate(inflater,container,false)

        adapterPuasa = PuasaAdapter()
        binding.recyclerPuasa.adapter = adapterPuasa
        binding.recyclerPuasa.setHasFixedSize(true)
        binding.recyclerPuasa.layoutManager = LinearLayoutManager(context)

        return binding.root

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitService = RetrofitService.buildservice(Retrofitinterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val mintadataPuasa = retrofitService.getDatakategoripuasa()
            //kondisi saat sukses show data
            if (mintadataPuasa.isSuccessful){
                val dataPuasa = mintadataPuasa.body() as List<PuasaItem>
                adapterPuasa.addData(dataPuasa)
                adapterPuasa.notifyDataSetChanged()
            }
        }
    }
}