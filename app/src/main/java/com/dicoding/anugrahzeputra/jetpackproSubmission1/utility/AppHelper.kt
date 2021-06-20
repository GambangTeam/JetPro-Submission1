package com.dicoding.anugrahzeputra.jetpackproSubmission1.utility

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object AppHelper {

    const val MOVIE_TYPE = "movie"
    const val TVSHOW_TYPE = "tvshow"

    fun setGlideImage(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).clear(imageView)
        Glide.with(context).load(imagePath).into(imageView)
    }
}