package com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.viewModel

import com.dicoding.anugrahzeputra.jetpackproSubmission1.utility.DummyData
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DummyData.dataMovie()[0]
    private val dummyTvShow = DummyData.dataTvShow()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setMovieId(movieId)
        viewModel.setTvShowId(tvShowId)
    }

    @Test
    fun getDetailMovieById() {
        val movie = viewModel.getDetailMovieById()
        Assert.assertNotNull(movie)
        assertEquals(dummyMovie.name, movie.name)
        assertEquals(dummyMovie.desc, movie.desc)
        assertEquals(dummyMovie.img_preview, movie.img_preview)
        assertEquals(dummyMovie.poster, movie.poster)
        assertEquals(dummyMovie.share_link, movie.share_link)
    }

    @Test
    fun getDetailTvShowById() {
        val tvShow = viewModel.getDetailTvShowById()
        Assert.assertNotNull(tvShow)
        assertEquals(dummyTvShow.name, tvShow.name)
        assertEquals(dummyTvShow.desc, tvShow.desc)
        assertEquals(dummyTvShow.img_preview, tvShow.img_preview)
        assertEquals(dummyTvShow.poster, tvShow.poster)
        assertEquals(dummyTvShow.share_link, tvShow.share_link)
    }
}