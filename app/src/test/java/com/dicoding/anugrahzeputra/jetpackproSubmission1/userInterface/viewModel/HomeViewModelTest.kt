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
    fun getListMovie() {
        val movies = viewModel.getListMovie()
        TestCase.assertNotNull(movies)
        TestCase.assertNotNull(movies)
        Assert.assertEquals(10, movies.size)
    }

    @Test
    fun getListTvShow() {
        val tvShows = viewModel.getListTvShow()
        TestCase.assertNotNull(tvShows)
        Assert.assertEquals(10, tvShows.size)
    }
}