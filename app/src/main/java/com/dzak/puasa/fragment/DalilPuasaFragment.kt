package com.dzak.puasa.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.puasa.adapter.DalilAdapter
import com.dzak.puasa.databinding.FragmentDalilPuasaBinding
import com.dzak.puasa.model.DalilPuasaItem
import com.dzak.puasa.network.RetrofitService
import com.dzak.puasa.network.Retrofitinterface
import kotlinx.coroutines.launch


class DalilPuasaFragment : Fragment() {

    private lateinit var  binding : FragmentDalilPuasaBinding
    private lateinit var adapterdalil : DalilAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDalilPuasaBinding.inflate(inflater,container,false)

        binding.recdalil.setHasFixedSize(true)
        binding.recdalil.layoutManager = LinearLayoutManager(context)
        adapterdalil = DalilAdapter()
        binding.recdalil.adapter = adapterdalil

        return binding.root
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitService = RetrofitService.buildservice(Retrofitinterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val mintadatadalilpuasa = retrofitService.getDataDalilPuasa()
            if (mintadatadalilpuasa.isSuccessful) {
                val datadalilpuasa = mintadatadalilpuasa.body() as List<DalilPuasaItem>
                adapterdalil.addData(datadalilpuasa)
                adapterdalil.notifyDataSetChanged()
            }
        }
    }
}