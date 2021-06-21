package com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.activity

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.anugrahzeputra.jetpackproSubmission1.R
import com.dicoding.anugrahzeputra.jetpackproSubmission1.databinding.ActivityDetailBinding
import com.dicoding.anugrahzeputra.jetpackproSubmission1.objectModels.FilmModel
import com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.viewModel.DetailViewModel
import com.dicoding.anugrahzeputra.jetpackproSubmission1.utility.AppHelper.MOVIE_TYPE
import com.dicoding.anugrahzeputra.jetpackproSubmission1.utility.AppHelper.TVSHOW_TYPE
import com.dicoding.anugrahzeputra.jetpackproSubmission1.utility.AppHelper.setGlideImage

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var film: FilmModel
    private lateinit var binding: ActivityDetailBinding
    //private lateinit var cbinding: ContentDetailBinding

    companion object {
        const val DATA_FILM = "data_film"
        const val FILM_TYPE = "film_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(
            this@DetailActivity,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        setSupportActionBar(binding.detailToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbarCollapse.setExpandedTitleColor(Color.TRANSPARENT)

        val data = intent.getStringExtra(DATA_FILM)
        val type = intent.getStringExtra(FILM_TYPE)

        if (type.equals(MOVIE_TYPE, ignoreCase = true)) {
            setToolbar(resources.getString(R.string.toolbar_detail_movie))
            data?.let {
                viewModel.setMovieId(it)
            }
            film = viewModel.getDetailMovieById()

        } else if (type.equals(TVSHOW_TYPE, ignoreCase = true)) {
            setToolbar(resources.getString(R.string.toolbar_detail_tvshow))
            data?.let {
                viewModel.setTvShowId(it)
            }
            film = viewModel.getDetailTvShowById()
        }

        binding.detailName.text = film.name
        binding.description.text = film.desc
        setGlideImage(this@DetailActivity, film.poster, binding.imagePoster)
        setGlideImage(this@DetailActivity, film.img_preview, binding.image)
        binding.btnShare.setOnClickListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun setToolbar(title: String) {
        supportActionBar?.title = title
    }

    override fun onClick(v: View?) {
        val sIntent = Intent(Intent.ACTION_VIEW)
        sIntent.data = Uri.parse(film.share_link)
        startActivity(sIntent)
    }
}

