package me.texy.treeviewdemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RedditData(val modhash: String? = null, val children: List<RedditPost>? = null) :
    Parcelable
