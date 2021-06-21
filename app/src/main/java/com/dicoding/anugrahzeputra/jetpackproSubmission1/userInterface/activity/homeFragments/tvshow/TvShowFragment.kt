package com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.activity.homeFragments.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.anugrahzeputra.jetpackproSubmission1.databinding.FragmentTvShowBinding
import com.dicoding.anugrahzeputra.jetpackproSubmission1.objectModels.FilmModel
import com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.activity.DetailActivity
import com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.viewModel.HomeViewModel
import com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.activity.homeFragments.FilmAdapter
import com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.activity.homeFragments.FilmCallback
import com.dicoding.anugrahzeputra.jetpackproSubmission1.utility.AppHelper.TVSHOW_TYPE
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment(),
    FilmCallback {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTvShowBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            )[HomeViewModel::class.java]
        }

        val listTvShow = viewModel.getListTvShow()
        setupRecyclerView(listTvShow)
    }

    private fun setupRecyclerView(data: List<FilmModel>) {
        binding.rvTvShow.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FilmAdapter(this@TvShowFragment)
        }.also {
            it.adapter.let { adapter ->
                when (adapter) {
                    is FilmAdapter -> {
                        adapter.setData(data)
                    }
                }
            }
        }
    }

    override fun onItemClicked(film: FilmModel) {
        startActivity(
            Intent(context,
                DetailActivity::class.java)
                .putExtra(DetailActivity.DATA_FILM, film.id)
                .putExtra(DetailActivity.FILM_TYPE, TVSHOW_TYPE)
        )
    }
}
