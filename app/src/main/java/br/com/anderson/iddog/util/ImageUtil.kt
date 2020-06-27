package br.com.anderson.iddog.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import br.com.anderson.iddog.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

/**
 * Created by anderson on 26/06/2020.
 */
object ImageUtil {

    fun setPicassoImage(imageView: ImageView, imgUrl: String?, progressBar: ProgressBar) {
        progressBar.visibility = View.VISIBLE
        Picasso.get()
            .load(imgUrl)
            .error(R.drawable.ic_error_white_48dp)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    progressBar.visibility = View.GONE
                }
            })
    }

    fun setPicassoImage(imageView: ImageView, imgUrl: String?) {
        Picasso.get()
            .load(imgUrl)
            .error(R.drawable.ic_error_white_48dp)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                }

                override fun onError(e: Exception?) {
                }
            })
    }
}