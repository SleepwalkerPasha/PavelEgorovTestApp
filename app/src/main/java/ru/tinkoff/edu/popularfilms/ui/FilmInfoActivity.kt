package ru.tinkoff.edu.popularfilms.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import ru.tinkoff.edu.popularfilms.databinding.ActivityFilmInfoBinding
import ru.tinkoff.edu.popularfilms.network.NetworkUtils
import ru.tinkoff.edu.popularfilms.ui.entities.Country
import ru.tinkoff.edu.popularfilms.ui.entities.Genre
import ru.tinkoff.edu.popularfilms.ui.viewmodel.FilmInfoViewModel

@Suppress("DEPRECATION")
class FilmInfoActivity : AppCompatActivity() {

    private val viewModel: FilmInfoViewModel by viewModels()

    private val networkUtils = NetworkUtils(this)

    private val binding: ActivityFilmInfoBinding by lazy {
        ActivityFilmInfoBinding.inflate(layoutInflater)
    }

    override fun onResume() {
        super.onResume()
        networkUtils.register()
    }

    override fun onStop() {
        super.onStop()
        networkUtils.unregister()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupObservers()
        val movieId = intent.getIntExtra(EXTRA_MOVIE_ID, 0)

        networkUtils.result = { isAvailable, type ->
            runOnUiThread {
                when (isAvailable) {
                    false -> {
                        startActivity(MainActivity.createIntent(this))
                    }
                    else -> {
                        viewModel.loadMovieById(movieId)
                    }
                }
            }
        }
    }

    private fun setupObservers() {
        viewModel.movie.observe(this) { movie ->
            with(binding) {
                titleView.text = movie.nameRu
                descriptionView.text = movie.description
                genresContent.text = movie.genres?.map(Genre::genre)?.joinToString(",")
                countriesContent.text = movie.countries?.map(Country::country)?.joinToString(",")
                Glide.with(posterImageView)
                    .load(movie.posterUrl)
                    .into(posterImageView)
            }
        }
    }

    companion object {

        private const val EXTRA_MOVIE_ID = "movie_id"
        fun createIntent(fragmentActivity: FragmentActivity, movieId: Int): Intent {
            val intent = Intent(fragmentActivity, FilmInfoActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_ID, movieId)
            return intent
        }
    }

}