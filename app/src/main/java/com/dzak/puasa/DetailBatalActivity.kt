package com.dzak.puasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dzak.puasa.databinding.ActivityDetailBatalBinding
import com.dzak.puasa.model.BatalPuasaItem

class DetailBatalActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBatalBinding

    companion object {
        const val Detail_Data_Batal = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBatalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<BatalPuasaItem>(Detail_Data_Batal)

        binding.txtDetailjudulbatal.text = data?.judul
        binding.txtDetaildeskbatal.text = data?.desk
        Glide.with(this).load(data?.gambar).into(binding.imgDetailbatal)
    }
}