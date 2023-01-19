package com.example.youtubeapi.data.model

data class Playlists(
    var kind: String,
    val items: List<Items>,
    val pageInfo: PageInfo
)

data class PageInfo(
    val totalResults: Int
)

data class Items(
    val id: String,
    val snippet: Snippet,
    val contentDetails: ContentDetails
)

data class ContentDetails(
    val itemCount: Int
)

data class Snippet(
    val channelId: String,
    val channelTitle: String,
    val description: String,
    val playlistId: String,
    val position: Int,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String,
    val videoOwnerChannelId: String,
    val videoOwnerChannelTitle: String
)

data class Thumbnails(
    val standard: Standard
)

data class Standard(
    val url: String
)
