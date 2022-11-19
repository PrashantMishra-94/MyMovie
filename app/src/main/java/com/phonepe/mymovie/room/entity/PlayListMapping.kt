package com.phonepe.mymovie.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playlist_mapping_table")
data class PlayListMapping (
    @PrimaryKey(autoGenerate = true)
    val uId: Int,
    @ColumnInfo(name = "playlist_id")
    val playListId: Int,
    @ColumnInfo(name = "movieId")
    val movieId: Int
)