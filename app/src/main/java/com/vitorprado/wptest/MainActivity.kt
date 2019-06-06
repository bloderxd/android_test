package com.vitorprado.wptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.vitorprado.wptest.databinding.ActivityMainBinding
import com.vitorprado.wptest.items.MoviesAdapter
import com.vitorprado.wptest.values.Category
import com.vitorprado.wptest.values.Movie

class MainActivity : AppCompatActivity(), MoviesContract {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.presenter = MoviesPresenter(this)
    }

    override fun setupList(movies: List<Movie>) {
        binding?.list?.layoutManager = LinearLayoutManager(this)
        binding?.list?.adapter = MoviesAdapter(movies)
    }

    override fun setupCategories(categories: List<Category>) {
        // create selector to filter movies
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.presenter?.onDestroy()
    }
}
