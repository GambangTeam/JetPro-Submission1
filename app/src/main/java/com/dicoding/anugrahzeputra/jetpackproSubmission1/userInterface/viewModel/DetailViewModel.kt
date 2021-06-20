package com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.viewModel

import androidx.lifecycle.ViewModel
import com.dicoding.anugrahzeputra.jetpackproSubmission1.objectModels.FilmModel
import com.dicoding.anugrahzeputra.jetpackproSubmission1.utility.DummyData

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    private fun getListMovie(): ArrayList<FilmModel> = DummyData.dataMovie() as ArrayList<FilmModel>
    private fun getListTvShow(): ArrayList<FilmModel> = DummyData.dataTvShow() as ArrayList<FilmModel>

    fun setMovieId(movieId: String){
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getDetailMovieById(): FilmModel {
        lateinit var result: FilmModel
        val listMovie = getListMovie()
        for (movie in listMovie){
            if (movie.id == movieId){
                result = movie
                break
            }
        }
        return result
    }

    fun getDetailTvShowById(): FilmModel {
        lateinit var result: FilmModel
        val listTvShow = getListTvShow()
        for (tvShow in listTvShow){
            if (tvShow.id == tvShowId){
                result = tvShow
                break
            }
        }
        return result
    }

}