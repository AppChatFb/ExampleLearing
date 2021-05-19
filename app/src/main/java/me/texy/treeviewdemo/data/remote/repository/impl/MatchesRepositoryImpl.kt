package me.texy.treeviewdemo.data.remote.repository.impl

import me.texy.treeviewdemo.data.model.CompetitionEntity
import me.texy.treeviewdemo.data.model.MatchEntity
import me.texy.treeviewdemo.data.remote.api.ApiService
import me.texy.treeviewdemo.data.remote.repository.MatchesRepository
import javax.inject.Inject
import javax.inject.Named

class MatchesRepositoryImpl @Inject constructor(
    @Named("apiFootball") private val apiService: ApiService
) : MatchesRepository {
    override suspend fun getCount(): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun getMatches(
        teamId: Int,
        dateFrom: String,
        dateTo: String
    ): List<MatchEntity>? = apiService.getMatchesForTeam(teamId, dateFrom, dateTo).matches

    override suspend fun getCompetition(id: Int): CompetitionEntity =
        apiService.getCompetitionById(id)

}