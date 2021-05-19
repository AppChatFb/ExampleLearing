package me.texy.treeviewdemo.ui.screen.hone

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import me.texy.treeviewdemo.R
import me.texy.treeviewdemo.databinding.FragmentCompetitionBinding
import me.texy.treeviewdemo.ui.screen.hone.adapter.CompetitionAdapter
import javax.inject.Inject

@AndroidEntryPoint
class CompetitionFragment : Fragment() {
    lateinit var binding: FragmentCompetitionBinding
    lateinit var layoutManager: LinearLayoutManager

    private val viewModel by viewModels<CompetitionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_competition, container, false)
        val competitionAdapter = CompetitionAdapter()
        layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rcCompetition.adapter = competitionAdapter
        binding.rcCompetition.layoutManager = layoutManager
        viewModel.getCompetitions()
        Log.d("TAG234", "onCreateView: ")
        viewModel.competitions.observe(viewLifecycleOwner) {
            if (it.size > 0) {
                competitionAdapter.submitList(it)
            }
        }

        return binding.root
    }

}