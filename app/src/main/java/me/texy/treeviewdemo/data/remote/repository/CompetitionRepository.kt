package me.texy.treeviewdemo.data.remote.repository

import me.texy.treeviewdemo.data.model.Competition
import me.texy.treeviewdemo.data.model.CompetitionEntity

interface CompetitionRepository {
    suspend fun getCount(): Int?
    suspend fun competitions(): List<Competition>?
    suspend fun getCompetitions(): List<Competition>?
}