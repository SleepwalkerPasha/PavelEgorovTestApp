package ru.tinkoff.edu.popularfilms.ui.fragments.cards

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.tinkoff.edu.popularfilms.api.entities.MovieApi
import ru.tinkoff.edu.popularfilms.databinding.FragmentFilmCardBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var data: List<MovieApi> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class MovieViewHolder(val binding: FragmentFilmCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(FragmentFilmCardBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = data[position]
        val context = holder.itemView.context

        with(holder.binding) {
//            if (movie.liked)
//                R.id.favView. = "visible"
            posterView.setImageURI(Uri.parse(movie.posterUrlPreview))
            nameView.text = movie.nameRu
            genreAndYearView.text = movie.genres?.get(0)?.genre + " (" + movie.year +")"
        }
    }
}