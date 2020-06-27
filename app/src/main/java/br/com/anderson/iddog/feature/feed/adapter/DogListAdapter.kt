package br.com.anderson.iddog.feature.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.anderson.iddog.R
import br.com.anderson.iddog.feature.base.CellClickListener

/**
 * Created by anderson on 26/06/2020.
 */
class DogListAdapter constructor(private var dogs: List<String>,
                                 private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<DogFeedItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogFeedItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_dog_feed, parent, false)

        return DogFeedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogFeedItemViewHolder, position: Int) {
        holder.bind(dogs[position])
        holder.itemView.setOnClickListener{
            cellClickListener.onCellClickListener(dogs[position])
        }
    }

    override fun getItemCount(): Int = dogs.size
}