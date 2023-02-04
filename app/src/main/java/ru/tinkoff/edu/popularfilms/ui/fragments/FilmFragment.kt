package ru.tinkoff.edu.popularfilms.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.tinkoff.edu.popularfilms.databinding.FragmentFilmBinding

class FilmFragment : Fragment() {

    private lateinit var binding: FragmentFilmBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFilmBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        fun newInstance(): FilmFragment {
            return FilmFragment()
        }
    }
}