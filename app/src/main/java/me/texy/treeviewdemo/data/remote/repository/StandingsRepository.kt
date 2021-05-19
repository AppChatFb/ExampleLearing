package me.texy.treeviewdemo.data.remote.repository

import me.texy.treeviewdemo.data.model.CompetitionEntity
import me.texy.treeviewdemo.data.model.StagesEntity

interface StandingsRepository {
    suspend fun getStages(id: Int): CompetitionEntity
    suspend fun getCompetition(id : Int): List<StagesEntity>?
}