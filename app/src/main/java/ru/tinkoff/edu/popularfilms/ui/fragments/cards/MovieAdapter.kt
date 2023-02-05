package ru.tinkoff.edu.popularfilms.ui.fragments.cards

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.tinkoff.edu.popularfilms.databinding.FragmentFilmCardBinding
import ru.tinkoff.edu.popularfilms.ui.fragments.entities.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList: List<Movie> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setMovieList(movieList: List<Movie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    class MovieViewHolder(val binding: FragmentFilmCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(FragmentFilmCardBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
//        val context = holder.itemView.context

        with(holder.binding) {
//            if (movie.liked)
//                R.id.favView. = "visible"
            Glide.with(posterView)
                .load(movie.posterUrlPreview)
                .into(posterView)
            nameView.text = movie.nameRu
            genreView.text = movie.genres?.get(0)?.genre
            yearView.text = movie.year.toString()
        }
    }
}