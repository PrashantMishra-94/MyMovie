package com.phonepe.mymovie.room.dao

import androidx.room.Dao
import androidx.room.Insert
import com.phonepe.mymovie.room.entity.PlayListMapping

@Dao
interface PlayListMappingDao {

    @Insert
    fun insert(mapping: PlayListMapping)
}