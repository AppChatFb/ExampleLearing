package me.texy.treeviewdemo.data.remote.response

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import me.texy.treeviewdemo.data.model.MatchEntity

@Keep
@Parcelize
data class MatchResponse(val match : MatchEntity? = null) : Parcelable