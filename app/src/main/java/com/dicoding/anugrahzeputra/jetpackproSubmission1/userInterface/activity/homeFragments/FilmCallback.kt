package com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.activity.homeFragments

import com.dicoding.anugrahzeputra.jetpackproSubmission1.objectModels.FilmModel

interface FilmCallback  {
    fun onItemClicked(film: FilmModel)
}