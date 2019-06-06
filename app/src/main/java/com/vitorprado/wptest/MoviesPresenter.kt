package com.vitorprado.wptest

import com.vitorprado.wptest.actions.GetMovies
import com.vitorprado.wptest.values.Category
import com.vitorprado.wptest.values.Movie
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers.io

class MoviesPresenter(
    private val contract: MoviesContract,
    private val getMovies: GetMovies = GetMovies()
) {

    private val compositeDisposable by lazy { CompositeDisposable() }
    private var moviesList: List<Movie>? = null

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        getMovies.execute()
            .subscribe(
                {
                    moviesList = it
                    with(contract) {
                        setupList(it)
                        setupCategories(getCategories(it))
                    }
                },
                { /* we will ignore errors */ }
            )
            .also {
                compositeDisposable.add(it)
            }
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