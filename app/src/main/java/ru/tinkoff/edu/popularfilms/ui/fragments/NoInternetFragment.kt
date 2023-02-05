package ru.tinkoff.edu.popularfilms.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.tinkoff.edu.popularfilms.databinding.FragmentNoInternetBinding


/**
 * A simple [Fragment] subclass.
 * Use the [NoInternetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoInternetFragment : Fragment() {

    private lateinit var binding: FragmentNoInternetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoInternetBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance(): NoInternetFragment = NoInternetFragment()
    }
}