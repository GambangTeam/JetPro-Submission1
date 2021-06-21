package com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.viewModel

import com.dicoding.anugrahzeputra.jetpackproSubmission1.utility.DummyData
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val movieData = DummyData.dataMovie()[0]
    private val TvShowData = DummyData.dataTvShow()[0]
    private val movieId = movieData.id
    private val tvShowId = TvShowData.id

    @Before
    fun setup() {
        viewModel = DetailViewModel()
        viewModel.setMovieId(movieId)
        viewModel.setTvShowId(tvShowId)
    }

    @Test
    fun checkDetailMovies() {
        val movies = viewModel.getDetailMovieById()
        Assert.assertNotNull(movies)
        assertEquals(movieData.name, movies.name)
        assertEquals(movieData.desc, movies.desc)
        assertEquals(movieData.img_preview, movies.img_preview)
        assertEquals(movieData.poster, movies.poster)
        assertEquals(movieData.share_link, movies.share_link)
    }

    @Test
    fun checkDetailTvShows() {
        val tvShows = viewModel.getDetailTvShowById()
        Assert.assertNotNull(tvShows)
        assertEquals(TvShowData.name, tvShows.name)
        assertEquals(TvShowData.desc, tvShows.desc)
        assertEquals(TvShowData.img_preview, tvShows.img_preview)
        assertEquals(TvShowData.poster, tvShows.poster)
        assertEquals(TvShowData.share_link, tvShows.share_link)
    }
}