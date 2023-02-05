package ru.tinkoff.edu.popularfilms.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ru.tinkoff.edu.popularfilms.databinding.FragmentNoInternetBinding
import ru.tinkoff.edu.popularfilms.ui.viewmodel.NoInternetViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [NoInternetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoInternetFragment : Fragment() {

    private lateinit var binding: FragmentNoInternetBinding

    private val viewModel: NoInternetViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoInternetBinding.inflate(inflater, container, false)
        binding.updateButton.setOnClickListener { onRepeatButton() }
        return binding.root
    }

    private fun onRepeatButton() {
        viewModel.selectCallback(true)
    }

    companion object {
        fun newInstance(): NoInternetFragment = NoInternetFragment()
    }
}