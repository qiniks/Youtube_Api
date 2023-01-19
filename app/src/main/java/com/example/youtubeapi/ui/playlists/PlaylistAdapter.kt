package com.example.youtubeapi.ui.playlists

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.R
import com.example.youtubeapi.ui.playlists.PlaylistAdapter.*
import com.example.youtubeapi.databinding.ItemPlaylistsBinding
import com.example.youtubeapi.data.model.Items
import com.example.youtubeapi.extension.loadImage

class PlaylistAdapter(
    private val list: ArrayList<Items>,
    private val clickListener: (id: String) -> Unit
) : RecyclerView.Adapter<PlaylistViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class PlaylistViewHolder(private val binding: ItemPlaylistsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(items: Items) {
            binding.tvVideoName.text = items.snippet.title
            binding.tvVideosAmount.text = itemView.context.getString(
                R.string.video_series,
                items.contentDetails.itemCount.toString()
            )
            binding.ivPlaylist.loadImage(items.snippet.thumbnails.standard.url)
            itemView.setOnClickListener { clickListener(items.id) }
        }
    }
}


