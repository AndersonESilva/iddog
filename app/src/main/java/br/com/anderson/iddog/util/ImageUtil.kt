package br.com.anderson.iddog.util

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import br.com.anderson.iddog.R
import br.com.anderson.iddog.util.Constants.Companion.ERROR_PICASSO
import br.com.anderson.iddog.util.Constants.Companion.SUCCESS_PICASSO
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

/**
 * Created by anderson on 26/06/2020.
 */
object ImageUtil {

    fun setPicassoImage(imageView: ImageView, imgUrl: String, progressBar: ProgressBar) {
        progressBar.visibility = View.VISIBLE
        if(imgUrl.isNullOrEmpty()){
            imageView.setImageResource(R.drawable.ic_error_black_48dp)
            progressBar.visibility = View.GONE
            Log.e(ERROR_PICASSO,"Url Error: $imgUrl")
        }else{
            Picasso.get()
                .load(imgUrl)
                .error(R.drawable.ic_error_black_48dp)
                .into(imageView, object : Callback {
                    override fun onSuccess() {
                        Log.v(SUCCESS_PICASSO,"Url Success: $imgUrl")
                        progressBar.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        Log.e(ERROR_PICASSO,"Url Error: $imgUrl")
                        progressBar.visibility = View.GONE
                    }
                })
        }
    }

    fun setPicassoImage(imageView: ImageView, imgUrl: String) {
        if(imgUrl.isNullOrEmpty()){
            imageView.setImageResource(R.drawable.ic_error_black_48dp)
            Log.e(ERROR_PICASSO,"Url Error: $imgUrl")
        }else{
            Picasso.get()
                .load(imgUrl)
                .error(R.drawable.ic_error_black_48dp)
                .into(imageView, object : Callback {
                    override fun onSuccess() {
                        Log.v(SUCCESS_PICASSO,"Url Success: $imgUrl")
                    }

                    override fun onError(e: Exception?) {
                        Log.e(ERROR_PICASSO,"Url Error: $imgUrl")
                    }
                })
        }
    }
}