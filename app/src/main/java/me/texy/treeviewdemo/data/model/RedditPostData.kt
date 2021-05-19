package me.texy.treeviewdemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RedditPostData(
    var id: String? = null,
    val subreddit: String? = null,
    val title: String? = null,
    val selftext: String? = null,
    val url: String? = null,
    val link_flair_text: String? = null,
    val thumbnail: String? = null,
    val author: String? = null,
    val permalink: String? = null,
    val score: Int? = null,
    val created_utc: Int? = null
) : Parcelable
