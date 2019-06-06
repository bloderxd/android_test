package com.vitorprado.wptest.items

import com.vitorprado.wptest.values.Movie

class MoviePresenter(
    private val movie: Movie
) {

    val title: String
        get() = "${movie.title} (${movie.year})"

    val stars: Float
        get() = movie.stars

    val category: String
        get() = movie.category.name

    val poster: String
        get() = movie.poster
}