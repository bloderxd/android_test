package com.vitorprado.wptest.values

data class Movie(
    val id: Long,
    val poster: String,
    val title: String,
    val stars: Float,
    val year: Int,
    val category: Category
)