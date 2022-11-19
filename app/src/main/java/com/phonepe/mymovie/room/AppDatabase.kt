package com.phonepe.mymovie.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.phonepe.mymovie.room.dao.PlayListDao
import com.phonepe.mymovie.room.dao.PlayListMappingDao
import com.phonepe.mymovie.room.entity.PlayList
import com.phonepe.mymovie.room.entity.PlayListMapping

@Database(entities = [PlayList::class, PlayListMapping::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun playListDao(): PlayListDao

    abstract fun playListMapping(): PlayListMappingDao

}