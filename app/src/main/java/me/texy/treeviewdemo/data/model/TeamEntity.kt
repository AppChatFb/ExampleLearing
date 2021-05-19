package me.texy.treeviewdemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamEntity(
    private var id: Int? = null,
    val name: String? = null,
    val crestUrl: String? = null,
    val clubColors: String? = null,
    val venue: String? = null,
    val founded: Int? = null,
    val area: AreaEntity? = null,
    val website: String? = null,
    val tla: String? = null
) : Parcelable
