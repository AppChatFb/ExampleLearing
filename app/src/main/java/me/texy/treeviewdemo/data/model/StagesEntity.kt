package me.texy.treeviewdemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StagesEntity(
    val stage: String? = null,
    val type: String? = null,
    val group: String? = null,
    val table: List<TableEntryEntity>? = null
) : Parcelable {
    companion object {
        const val TYPE_TOTAL = "TOTAL"
    }
}
