package com.vitorprado.wptest

import com.vitorprado.wptest.actions.GetMovies
import com.vitorprado.wptest.values.Category
import com.vitorprado.wptest.values.Movie
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesPresenter(
    private val contract: MoviesContract,
    private val getMovies: GetMovies = GetMovies()
) : ScopedPresenter() {

    private val compositeDisposable by lazy { CompositeDisposable() }
    private var moviesList: List<Movie>? = null

    init {
        fetchMovies()
    }

    private fun fetchMovies() = launch {
        withContext(Dispatchers.IO) { getMovies.execute().get() }.also { with(contract) {
            moviesList = it
            setupList(it)
            setupCategories(getCategories(it))
        }}
    }

    fun filterMoviesByCategory(category: Category) {
        contract.setupList(filteredMovies(category))
    }

    fun clearFilter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun filteredMovies(category: Category): List<Movie> {
        return listOf()
    }

    private fun getCategories(movies: List<Movie>): List<Category> {
        return listOf()
    }

    fun onDestroy() {
        compositeDisposable.dispose()
    }
}