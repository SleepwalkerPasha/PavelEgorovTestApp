package ru.tinkoff.edu.popularfilms.ui.fragments.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.tinkoff.edu.popularfilms.databinding.FragmentFilmCardBinding


/**
 * A simple [Fragment] subclass.
 * Use the [FilmCardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilmCardFragment : Fragment() {

    private lateinit var binding: FragmentFilmCardBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFilmCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance(): FilmCardFragment {
            return FilmCardFragment()
        }
    }
}