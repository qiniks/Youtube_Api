package com.example.youtubeapi.ui.playlists

import android.content.Intent
import android.net.ConnectivityManager
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.R
import com.example.youtubeapi.core.ui.BaseActivity
import com.example.youtubeapi.core.network.Connection
import com.example.youtubeapi.databinding.ActivityPlaylistBinding
import com.example.youtubeapi.data.model.Items
import com.example.youtubeapi.ui.infoplaylists.InfoPlaylistActivity

class PlaylistActivity : BaseActivity<MainViewModel, ActivityPlaylistBinding>() {

    private lateinit var adapter: PlaylistAdapter

    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    private fun clickListener(id: String) {
        Intent(this, InfoPlaylistActivity::class.java).apply {
            putExtra(KEY_FOR_ID, id)
            startActivity(this)
        }
    }

    override fun initViewModel() {
        viewModel.playlist().observe(this) {
            if (it != null) {
                adapter = PlaylistAdapter(it.items as ArrayList<Items>, this::clickListener)
            }
            binding.rvPlaylist.adapter = adapter
        }
    }

    override fun checkInternet() {
        Connection((getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager))
            .observe(this) {
                binding.includedInternet.constInternet.isVisible = !it
                binding.rvPlaylist.isVisible = it
            }
    }

    companion object {
        const val KEY_FOR_ID = R.string.connection.toString()
    }
}