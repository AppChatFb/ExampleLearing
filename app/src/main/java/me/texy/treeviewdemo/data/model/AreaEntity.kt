package me.texy.treeviewdemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AreaEntity(val countryCode: String,
                      val ensignUrl: String,
                      val id: Int,
                      val name: String) : Parcelable
