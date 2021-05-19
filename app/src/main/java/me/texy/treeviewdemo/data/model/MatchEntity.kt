package me.texy.treeviewdemo.data.model

import android.os.Build
import android.os.Parcelable
import androidx.annotation.RequiresApi
import kotlinx.parcelize.Parcelize
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import kotlin.collections.HashMap

@Parcelize
data class MatchEntity(
    val id: Int? = null,
    val season: SeasonEntity? = null,
    val utcDate: Date? = null,
    val status: String? = null,
    val matchDay: Int? = null,
    val stage: Int? = null,
    val group: String? = null,
    val homeTeam: HashMap<String, String>? = null,
    val awayTeam: HashMap<String, String>? = null,
    val competition: CompetitionEntity? = null,
    val score: ScoreEntity? = null
) : Parcelable {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getLocalDateTime(): LocalDateTime {
        return Instant.ofEpochMilli(utcDate!!.time)
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()
    }
}
