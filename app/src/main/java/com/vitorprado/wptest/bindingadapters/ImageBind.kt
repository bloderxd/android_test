package com.vitorprado.wptest.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {
    //set image using Picasso
}