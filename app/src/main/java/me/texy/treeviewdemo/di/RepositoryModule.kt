package me.texy.treeviewdemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.texy.treeviewdemo.data.remote.repository.CompetitionRepository
import me.texy.treeviewdemo.data.remote.repository.MatchesRepository
import me.texy.treeviewdemo.data.remote.repository.StandingsRepository
import me.texy.treeviewdemo.data.remote.repository.impl.CompetitionRepositoryImpl
import me.texy.treeviewdemo.data.remote.repository.impl.MatchesRepositoryImpl
import me.texy.treeviewdemo.data.remote.repository.impl.StandingRepositoryImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCompetitionRepository(
        competitionRepositoryImpl: CompetitionRepositoryImpl
    ): CompetitionRepository = competitionRepositoryImpl

    @Singleton
    @Provides
    fun provideMatchesRepository(
        matchesRepositoryImpl: MatchesRepositoryImpl
    ): MatchesRepository = matchesRepositoryImpl

    @Singleton
    @Provides
    fun provideStandingsRepository(
        standingRepositoryImpl: StandingRepositoryImpl
    ): StandingsRepository = standingRepositoryImpl
}