package com.example.youtubeapi.ui.playlists

import androidx.lifecycle.LiveData
import com.example.youtubeapi.App
import com.example.youtubeapi.core.ui.BaseViewModel
import com.example.youtubeapi.data.model.Playlists

class MainViewModel : BaseViewModel() {
    fun playlist(): LiveData<Playlists> {
        return App().repository.getPlaylists()
    }
}