package com.dzak.puasa.network

import com.dzak.puasa.model.BatalPuasaItem
import com.dzak.puasa.model.DalilPuasaItem
import com.dzak.puasa.model.PuasaItem
import retrofit2.Response
import retrofit2.http.GET

interface Retrofitinterface {
    @GET("Data/kategoripuasa.json")
    suspend fun getDatakategoripuasa() : Response<List<PuasaItem>>

    @GET("Data/dalilpuasa.json")
    suspend fun getDataDalilPuasa() : Response<List<DalilPuasaItem>>

    @GET("Data/batalpuasa.json")
    suspend fun getDatabatalpuasa() : Response<List<BatalPuasaItem>>
}