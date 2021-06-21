package com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.viewModel

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel()
    }

    @Test
    fun checkListMovies() {
        val listMovies = viewModel.getListMovie()
        TestCase.assertNotNull(listMovies)
        Assert.assertEquals(10, listMovies.size)
    }

    @Test
    fun checkListTvShows() {
        val listTvShows = viewModel.getListTvShow()
        TestCase.assertNotNull(listTvShows)
        Assert.assertEquals(10, listTvShows.size)
    }
}