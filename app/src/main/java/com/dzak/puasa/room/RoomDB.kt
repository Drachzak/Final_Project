package com.dzak.puasa.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dzak.puasa.model.BatalPuasaItem

@Database (entities = [BatalPuasaItem::class], version = 1, exportSchema = false)

abstract class RoomDB : RoomDatabase() {
    abstract fun roomDao() : RoomDao


    companion object {
        private var roomdatabseitem : RoomDB? = null

        fun getRoomDatabaseItem (context : Context) : RoomDB {
            return roomdatabseitem ?: synchronized(this){
                roomdatabseitem ?: Room.databaseBuilder(context,RoomDB::class.java,"item.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }
    }


}