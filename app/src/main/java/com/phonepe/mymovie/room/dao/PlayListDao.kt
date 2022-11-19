package com.phonepe.mymovie.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.phonepe.mymovie.room.entity.PlayList

@Dao
interface PlayListDao {

    @Insert
    fun insert(vararg playList: PlayList)

    @Query("SELECT * FROM playlist_table")
    fun getAllPlayList(): ArrayList<PlayList>

}