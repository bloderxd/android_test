package com.vitorprado.wptest.actions

import com.vitorprado.wptest.values.Category
import com.vitorprado.wptest.values.Movie
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import result.Result

class GetMovies {
    fun execute(): Result<List<Movie>> = Result.ok(
            listOf(
                Movie(
                    id = 1,
                    title = "Fight Club",
                    poster = "https://m.media-amazon.com/images/M/MV5BMjJmYTNkNmItYjYyZC00MGUxLWJhNWMtZDY4Nzc1MDAwMzU5XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,676,1000_AL_.jpg",
                    stars = 5f,
                    year = 1999,
                    category = Category(1, "Drama")
                ),
                Movie(
                    id = 2,
                    title = "Memento",
                    poster = "https://m.media-amazon.com/images/M/MV5BZTcyNjk1MjgtOWI3Mi00YzQwLWI5MTktMzY4ZmI2NDAyNzYzXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,681,1000_AL_.jpg",
                    stars = 5f,
                    year = 2000,
                    category = Category(2, "Thriller")
                ),
                Movie(
                    id = 3,
                    title = "Mr. Nobody",
                    poster = "https://m.media-amazon.com/images/M/MV5BMTg4ODkzMDQ3Nl5BMl5BanBnXkFtZTgwNTEwMTkxMDE@._V1_SY1000_CR0,0,675,1000_AL_.jpg",
                    stars = 5f,
                    year = 2009,
                    category = Category(1, "Drama")
                ),
                Movie(
                    id = 4,
                    title = "Oldeuboi",
                    poster = "https://m.media-amazon.com/images/M/MV5BMTI3NTQyMzU5M15BMl5BanBnXkFtZTcwMTM2MjgyMQ@@._V1_.jpg",
                    stars = 4.4f,
                    year = 2003,
                    category = Category(1, "Drama")
                ),
                Movie(
                    id = 5,
                    title = "Inception",
                    poster = "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg",
                    stars = 4.8f,
                    year = 2010,
                    category = Category(3, "Sci-Fi")
                ),
                Movie(
                    id = 6,
                    title = "Cidade de Deus",
                    poster = "https://m.media-amazon.com/images/M/MV5BMGU5OWEwZDItNmNkMC00NzZmLTk1YTctNzVhZTJjM2NlZTVmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SY1000_CR0,0,677,1000_AL_.jpg",
                    stars = 4.9f,
                    year = 2002,
                    category = Category(4, "Crime")
                ),
                Movie(
                    id = 7,
                    title = "American Beauty",
                    poster = "https://m.media-amazon.com/images/M/MV5BNTBmZWJkNjctNDhiNC00MGE2LWEwOTctZTk5OGVhMWMyNmVhXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg",
                    stars = 4.9f,
                    year = 1999,
                    category = Category(1, "Drama")
                ),
                Movie(
                    id = 8,
                    title = "Requiem for a Dream",
                    poster = "https://m.media-amazon.com/images/M/MV5BOTdiNzJlOWUtNWMwNS00NmFlLWI0YTEtZmI3YjIzZWUyY2Y3XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,666,1000_AL_.jpg",
                    stars = 4.5f,
                    year = 2000,
                    category = Category(1, "Drama")
                ),
                Movie(
                    id = 9,
                    title = "Donnie Darko",
                    poster = "https://m.media-amazon.com/images/M/MV5BZjZlZDlkYTktMmU1My00ZDBiLWFlNjEtYTBhNjVhOTM4ZjJjXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg",
                    stars = 4.4f,
                    year = 2001,
                    category = Category(3, "Sci-Fi")
                ),
                Movie(
                    id = 10,
                    title = "The Salt of the Earth",
                    poster = "https://m.media-amazon.com/images/M/MV5BNzUyODI4MzE5N15BMl5BanBnXkFtZTgwMjQxNzk3MTE@._V1_SY1000_CR0,0,749,1000_AL_.jpg",
                    stars = 4.7f,
                    year = 2014,
                    category = Category(5, "Documentary")
                ),
                Movie(
                    id = 11,
                    title = "The Girl with the Dragon Tattoo",
                    poster = "https://m.media-amazon.com/images/M/MV5BMTczNDk4NTQ0OV5BMl5BanBnXkFtZTcwNDAxMDgxNw@@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
                    stars = 4.3f,
                    year = 2011,
                    category = Category(4, "Crime")
                ),
                Movie(
                    id = 12,
                    title = "Ex Machina",
                    poster = "https://m.media-amazon.com/images/M/MV5BMTUxNzc0OTIxMV5BMl5BanBnXkFtZTgwNDI3NzU2NDE@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
                    stars = 4.1f,
                    year = 2014,
                    category = Category(3, "Sci-Fi")
                ),
                Movie(
                    id = 13,
                    title = "Little Miss Sunshine",
                    poster = "https://m.media-amazon.com/images/M/MV5BMTgzNTgzODU0NV5BMl5BanBnXkFtZTcwMjEyMjMzMQ@@._V1_SY1000_CR0,0,677,1000_AL_.jpg",
                    stars = 4.5f,
                    year = 2006,
                    category = Category(6, "Comedy")
                ),
                Movie(
                    id = 14,
                    title = "Her",
                    poster = "https://m.media-amazon.com/images/M/MV5BMjA1Nzk0OTM2OF5BMl5BanBnXkFtZTgwNjU2NjEwMDE@._V1_.jpg",
                    stars = 4.2f,
                    year = 2013,
                    category = Category(1, "Drama")
                )
            ).sortedBy { it.title }
    )
}