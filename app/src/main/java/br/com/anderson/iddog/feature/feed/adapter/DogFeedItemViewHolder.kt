package br.com.anderson.iddog.feature.feed.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.anderson.iddog.util.ImageUtil
import kotlinx.android.synthetic.main.list_item_dog_feed.view.*

/**
 * Created by anderson on 26/06/2020.
 */
class DogFeedItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(dogImgUrl: String) {
        itemView.picture
        ImageUtil.setPicassoImage(itemView.picture, dogImgUrl, itemView.progressBar)
    }
}