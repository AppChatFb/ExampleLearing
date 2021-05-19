package me.texy.treeviewdemo.data.remote.api

import me.texy.treeviewdemo.data.model.CompetitionEntity
import me.texy.treeviewdemo.data.model.RepositoryAll
import me.texy.treeviewdemo.data.model.TeamEntity
import me.texy.treeviewdemo.data.remote.response.CompetitionResponse
import me.texy.treeviewdemo.data.remote.response.MatchResponse
import me.texy.treeviewdemo.data.remote.response.MatchesResponse
import me.texy.treeviewdemo.data.remote.response.StandingsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET(ApiPath.TOURNAMENTS)
    suspend fun getCompetitions(): RepositoryAll

    @GET("${ApiPath.TOURNAMENT_ID}{id}")
    suspend fun getCompetitionById(@Path("id") id: Int): CompetitionEntity

    @GET("competitions/{id}/standings")
    suspend fun getCompetitionStandings(@Path("id") id: Int): StandingsResponse

    @GET("${ApiPath.TEAMS}{id}")
    suspend fun getTeamById(@Path("id") id: Int): TeamEntity

    @GET("${ApiPath.MATCHES}{id}")
    suspend fun getMatchById(@Path("id") id: Int): MatchResponse

    @GET("competitions/{id}/matches")
    suspend fun getMatchesForCompetition(
        @Path("id") id: Int,
        @Query("matchday") matchday: Int
    ): MatchResponse

    @GET("teams/{id}/matches")
    suspend fun getMatchesForTeam(
        @Path("id") teamId: Int,
        @Query("dateFrom") dateFrom: String,
        @Query("dateTo") dateTo: String
    ): MatchesResponse
}