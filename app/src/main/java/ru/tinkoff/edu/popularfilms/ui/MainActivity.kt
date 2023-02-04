package ru.tinkoff.edu.popularfilms.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.tinkoff.edu.popularfilms.databinding.ActivityMainBinding
import ru.tinkoff.edu.popularfilms.ui.fragments.FilmFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
    }

    private fun loadData() {
        supportFragmentManager.beginTransaction()
            .add(binding.mainScreenContainer.id, FilmFragment.newInstance())
            .commit()
    }
}