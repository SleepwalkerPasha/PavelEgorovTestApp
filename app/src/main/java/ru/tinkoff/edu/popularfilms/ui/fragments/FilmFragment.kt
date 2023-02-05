package ru.tinkoff.edu.popularfilms.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.tinkoff.edu.popularfilms.databinding.FragmentFilmBinding
import ru.tinkoff.edu.popularfilms.ui.FilmInfoActivity
import ru.tinkoff.edu.popularfilms.ui.adapter.MovieAdapter
import ru.tinkoff.edu.popularfilms.ui.entities.Movie
import ru.tinkoff.edu.popularfilms.ui.viewmodel.MovieViewModel

class FilmFragment : Fragment() {

    private lateinit var binding: FragmentFilmBinding

    private val viewModel: MovieViewModel by viewModels()

    private val movieAdapter = MovieAdapter(this::onMovieClick, this::onMovieLongClick)

    private fun onMovieClick(movie: Movie) {
        val intent = FilmInfoActivity.createIntent(requireActivity(), movie.filmId)
        startActivity(intent)
    }

    private fun onMovieLongClick(movie: Movie) {
        movie.liked = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFilmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setupObservers()
        viewModel.loadTop100Movies()
    }

    private fun setupUi() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = movieAdapter
        }
    }

    private fun setupObservers() {
        viewModel.movies.observe(viewLifecycleOwner) {
            movieAdapter.setMovieList(it)
        }
    }

    companion object {

        fun newInstance(): FilmFragment {
            return FilmFragment()
        }
    }
}