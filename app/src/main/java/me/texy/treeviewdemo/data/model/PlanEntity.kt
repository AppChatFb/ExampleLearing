package me.texy.treeviewdemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlanEntity(val plan : String) : Parcelable