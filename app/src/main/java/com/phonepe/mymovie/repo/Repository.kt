package com.phonepe.mymovie.repo

import android.content.Context
import androidx.room.Room
import com.phonepe.mymovie.R
import com.phonepe.mymovie.room.AppDatabase
import com.phonepe.mymovie.room.entity.PlayList
import com.phonepe.mymovie.webService.RetrofitInstance

class Repository(private val context: Context) {

    private val db: AppDatabase by lazy {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()
    }

    suspend fun getMoviesList() = RetrofitInstance.getWebService().getPopularMoviesList(context.getString(R.string.api_key))

    suspend fun getAllPlayList() = db.playListDao().getAllPlayList()

    suspend fun savePlayList(playList: PlayList) = db.playListDao().insert(playList)

}