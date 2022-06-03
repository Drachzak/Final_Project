package com.dzak.puasa.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PuasaItem(
    @Json(name = "judul")
    var title : String = "",
    var data : List<BatalPuasaItem> = arrayListOf()

) : Parcelable
