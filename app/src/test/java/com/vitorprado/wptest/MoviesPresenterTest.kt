package com.vitorprado.wptest

import com.nhaarman.mockitokotlin2.*
import com.vitorprado.wptest.actions.GetMovies
import com.vitorprado.wptest.values.Category
import com.vitorprado.wptest.values.Movie
import io.reactivex.Single
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should contain`
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.`when`
import org.mockito.Mockito.eq
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object MoviesPresenterTest : Spek( {

    describe("MoviesPresenterTest") {

        context("with one category") {
            val contract = mock<MoviesContract>()
            val getMovies = mock<GetMovies>()
            val category = Category(1, "Drama")
            `when`(getMovies.execute()).thenReturn(Single.just(listOf(Movie(0, "", "", 0f, 0, category))))

            val presenter = MoviesPresenter(contract, getMovies)

            it("should show one category") {
                verify(contract, atLeastOnce()).setupList(ArgumentMatchers.anyList())
                verify(contract, atLeastOnce()).setupCategories(argThat{ size == 1 && contains(category) })
            }
        }
    }
})