package me.texy.treeviewdemo.data.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import me.texy.treeviewdemo.data.model.CompetitionEntity
import me.texy.treeviewdemo.data.model.MatchEntity

@Parcelize
data class MatchesResponse(
    val count: Int? = null,
    val matches: List<MatchEntity>? = null,
    val competition: CompetitionEntity? = null
) : Parcelable
