package com.dzak.puasa.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "item")
@Parcelize
data class BatalPuasaItem(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    @Json(name = "gambar")
    var gambar : String?,
    @Json(name = "judul")
    var judul : String?,
    @Json(name = "desk")
    var desk : String?,
    var type : String?
) : Parcelable
