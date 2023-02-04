package ru.tinkoff.edu.popularfilms.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.tinkoff.edu.popularfilms.R

class FilmFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_fragment)
    }
}