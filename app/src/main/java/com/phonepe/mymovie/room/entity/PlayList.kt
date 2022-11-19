package com.phonepe.mymovie.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playlist_table")
data class PlayList(
    @PrimaryKey(autoGenerate = true)
    val uId: Int,
    @ColumnInfo(name = "name")
    val name: String
)