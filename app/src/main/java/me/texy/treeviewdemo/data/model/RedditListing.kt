package me.texy.treeviewdemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RedditListing(val kind: String? = null, val data: RedditData? = null) : Parcelable
