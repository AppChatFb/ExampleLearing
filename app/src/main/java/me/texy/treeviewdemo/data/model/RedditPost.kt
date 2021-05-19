package me.texy.treeviewdemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RedditPost(val kind: String? = null, val data: RedditData? = null) : Parcelable