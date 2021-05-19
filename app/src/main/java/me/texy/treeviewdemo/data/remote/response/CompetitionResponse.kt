package me.texy.treeviewdemo.data.remote.response

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import me.texy.treeviewdemo.data.model.CompetitionEntity
import me.texy.treeviewdemo.data.model.PlanEntity

@Keep
@Parcelize
@JsonClass(generateAdapter = true)
data class CompetitionResponse(
    val count: Int? = null,
    val filters: ArrayList<PlanEntity>? = null,
    val competitions: List<CompetitionEntity>? = null
) : BaseResponse()