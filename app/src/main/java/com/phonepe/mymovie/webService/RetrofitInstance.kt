package com.phonepe.mymovie.webService

import com.google.gson.GsonBuilder
import com.phonepe.mymovie.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private var retrofit: Retrofit? = null
    private var webService: WebService? = null

    private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

    private fun getInstance(): Retrofit {
        if (retrofit == null) {
            val gson = GsonBuilder().serializeNulls().create()
            val client = if (BuildConfig.DEBUG) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                OkHttpClient.Builder().addInterceptor(interceptor).build()
            } else {
                OkHttpClient.Builder().build()
            }
            retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(client).
            addConverterFactory(GsonConverterFactory.create(gson)).build()
        }
        return retrofit!!
    }

    fun getWebService(): WebService {
        if (webService == null) {
            webService = getInstance().create(WebService::class.java)
        }
        return webService!!
    }
}