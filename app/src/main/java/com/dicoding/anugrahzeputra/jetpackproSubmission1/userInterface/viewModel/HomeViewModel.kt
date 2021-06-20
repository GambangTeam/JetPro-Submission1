package com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.viewModel

import androidx.lifecycle.ViewModel
import com.dicoding.anugrahzeputra.jetpackproSubmission1.objectModels.FilmModel
import com.dicoding.anugrahzeputra.jetpackproSubmission1.utility.DummyData

class HomeViewModel : ViewModel() {

    fun getListMovie(): List<FilmModel> = DummyData.dataMovie()

    fun getListTvShow(): List<FilmModel> = DummyData.dataTvShow()

}