package me.texy.treeviewdemo.data.remote.repository.impl

import android.util.Log
import me.texy.treeviewdemo.data.model.Competition
import me.texy.treeviewdemo.data.model.CompetitionEntity
import me.texy.treeviewdemo.data.remote.api.ApiService
import me.texy.treeviewdemo.data.remote.repository.CompetitionRepository
import javax.inject.Inject
import javax.inject.Named

class CompetitionRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CompetitionRepository {
    override suspend fun getCount(): Int? =
        apiService.getCompetitions().count

    override suspend fun competitions(): List<Competition>? {
        Log.d("TAG256", "competitions:  lay data")
        return apiService.getCompetitions().competitions
    }


    override suspend fun getCompetitions(): List<Competition>? {
        Log.d("TAG256", "competitions:  lay data")
        return apiService.getCompetitions().competitions
    }
}