package br.com.anderson.iddog.feature.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.anderson.iddog.R

/**
 * Created by anderson on 26/06/2020.
 */
class DogListAdapter constructor(private var users: List<String>) : RecyclerView.Adapter<DogFeedItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogFeedItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_dog_feed, parent, false)

        return DogFeedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogFeedItemViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size
}