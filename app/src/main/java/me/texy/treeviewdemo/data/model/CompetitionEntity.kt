package me.texy.treeviewdemo.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@JsonClass(generateAdapter = true)
data class CompetitionEntity(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "code") val code: String? = null,
    @Json(name = "currentSeason") val currentSeason: SeasonEntity? = null,
    @Json(name = "area") val area: AreaEntity? = null,
    val emblemUrl: String? = null,
    val plan: String? = null,
    val numberOfAvailableSeasons: String? = null,
    val lastUpdated: String? = null
) : Parcelable
