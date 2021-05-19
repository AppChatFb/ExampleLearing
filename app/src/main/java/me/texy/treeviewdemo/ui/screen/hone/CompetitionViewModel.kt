package me.texy.treeviewdemo.ui.screen.hone

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.texy.treeviewdemo.data.model.Competition
import me.texy.treeviewdemo.data.model.CompetitionEntity
import me.texy.treeviewdemo.data.remote.repository.CompetitionRepository
import javax.inject.Inject

@HiltViewModel
class CompetitionViewModel @Inject constructor(
    private val competitionRepository: CompetitionRepository
) : ViewModel() {
    val competitions = MutableLiveData<List<Competition>>()
    init {
        getCompetitions()
    }
    fun getCompetitions() {
        viewModelScope.launch {
            try {
                val competitionList = ArrayList(competitionRepository.getCompetitions() ?: listOf())
                Log.d("TAG234", "getCompetitions:   " + competitionRepository.getCompetitions()?.size)
                competitions.value = competitionList
            } catch (ex: Throwable) {
                Log.d("TAG234", "Error:   ")
            }
        }
    }
}