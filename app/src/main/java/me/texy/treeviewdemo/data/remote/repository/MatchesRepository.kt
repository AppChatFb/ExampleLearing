package me.texy.treeviewdemo.data.remote.repository

import me.texy.treeviewdemo.data.model.CompetitionEntity
import me.texy.treeviewdemo.data.model.MatchEntity

interface MatchesRepository {
    suspend fun getCount(): Int?
    suspend fun getMatches(teamId: Int, dateFrom: String, dateTo: String): List<MatchEntity>?
    suspend fun getCompetition(id: Int): CompetitionEntity
}