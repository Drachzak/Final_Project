package com.dzak.puasa.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dzak.puasa.model.BatalPuasaItem

@Dao
interface RoomDao {

    //menampilkan semua data sesuai typenya
    //CRUD = R Read
    @Query ("SELECT * FROM item WHERE type = :type")
    fun getDatabyType(type : String) : LiveData<List<BatalPuasaItem>>

    //Menghapus semua data
    //CRUD = D Delete
    @Query ("DELETE FROM item")
    suspend fun resetDatabase()

    //Menghapus per 1 Data
    //CRUD = D Delete
    @Query("DELETE FROM  item  WHERE type = :type")
    suspend fun resetType(type: String)

    //Membuat data
    //CRUD = C Create
    @Insert
    suspend fun insertData(data : List<BatalPuasaItem>)

}