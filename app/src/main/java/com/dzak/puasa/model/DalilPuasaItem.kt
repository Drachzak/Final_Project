package com.dzak.puasa.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DalilPuasaItem(
    var id : Int = 0,
    @Json(name = "gambar")
    var gambar : String?,
    @Json(name = "judul")
    var judul : String?,
    @Json(name = "desk")
    var deskripsi : String?
) : Parcelable
