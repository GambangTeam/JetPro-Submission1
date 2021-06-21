package com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dicoding.anugrahzeputra.jetpackproSubmission1.R
import com.dicoding.anugrahzeputra.jetpackproSubmission1.databinding.ActivityHomeBinding
import com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.viewModel.HomeViewModel
import com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.activity.homeFragments.movie.MovieFragment
import com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.activity.homeFragments.tvshow.TvShowFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this@HomeActivity,
            ViewModelProvider.NewInstanceFactory()
        )[HomeViewModel::class.java]

        setSupportActionBar(binding.toolbar)
        supportActionBar?.elevation = 8F

        setNavBar()
    }

    private fun setNavBar() {
        val movieFragment = MovieFragment()
        val tvShowFragment = TvShowFragment()

        setFragment(movieFragment, resources.getString(R.string.tab_movie))

        binding.navbar.setNavigationChangeListener { view, _ ->
            when (view.id) {
                R.id.nav_movie -> setFragment(
                    movieFragment,
                    resources.getString(R.string.tab_movie)
                )
                R.id.nav_tvshow -> setFragment(
                    tvShowFragment,
                    resources.getString(R.string.tab_tvshow)
                )
            }
        }
    }

    private fun setFragment(fragment: Fragment, title: String) {
        val fManager = supportFragmentManager
        fManager.beginTransaction().apply {
            replace(R.id.container_main_fragment, fragment)
        }.commit()

        supportActionBar?.title = title
    }
}
