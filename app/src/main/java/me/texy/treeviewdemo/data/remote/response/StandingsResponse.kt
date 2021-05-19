package me.texy.treeviewdemo.data.remote.response

import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import me.texy.treeviewdemo.data.model.StagesEntity

@Keep
@Parcelize
data class StandingsResponse(
    val competition: CompetitionResponse? = null,
    val standings: List<StagesEntity>? = null
) : BaseResponse() {
}