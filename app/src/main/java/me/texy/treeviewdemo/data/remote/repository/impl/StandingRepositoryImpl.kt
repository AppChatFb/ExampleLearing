package me.texy.treeviewdemo.data.remote.repository.impl

import me.texy.treeviewdemo.data.model.CompetitionEntity
import me.texy.treeviewdemo.data.model.StagesEntity
import me.texy.treeviewdemo.data.remote.api.ApiService
import me.texy.treeviewdemo.data.remote.repository.StandingsRepository
import javax.inject.Inject
import javax.inject.Named

class StandingRepositoryImpl @Inject constructor(
    @Named("apiFootball") private val apiService: ApiService
) : StandingsRepository {
    override suspend fun getStages(id: Int): CompetitionEntity = apiService.getCompetitionById(id)

    override suspend fun getCompetition(id: Int): List<StagesEntity>? =
        apiService.getCompetitionStandings(id).standings

}