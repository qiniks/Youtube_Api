package com.example.youtubeapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.data.remote.ApiService
import com.example.youtubeapi.core.network.RetrofitClient
import com.example.youtubeapi.data.model.Playlists
import retrofit2.Call
import retrofit2.Response

class Repository {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists(): LiveData<Playlists> {
        val data = MediatorLiveData<Playlists>()

        apiService.getPlaylists(
            "snippet,contentDetails", "UC6JRrn_7Qe1CZBcQDMieadw",
            BuildConfig.API_KEY, 50
        )
            .enqueue(object : retrofit2.Callback<Playlists> {
                override fun onResponse(call: Call<Playlists>, response: Response<Playlists>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Playlists>, t: Throwable) {
                }
            })
        return data
    }
}