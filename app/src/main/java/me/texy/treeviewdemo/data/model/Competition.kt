package me.texy.treeviewdemo.data.model

data class Competition(
    val area: Area,
    val code: String,
    val currentSeason: CurrentSeason,
    val emblemUrl: Any,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val numberOfAvailableSeasons: Int,
    val plan: String
)