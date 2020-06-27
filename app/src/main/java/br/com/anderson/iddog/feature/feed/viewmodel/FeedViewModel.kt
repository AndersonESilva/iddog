package br.com.anderson.iddog.feature.feed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import br.com.anderson.iddog.data.response.DogResponse
import br.com.anderson.iddog.data.response.Resouce
import br.com.anderson.iddog.feature.base.BaseViewModel
import br.com.anderson.iddog.service.repository.FeedRepository
import javax.inject.Inject

/**
 * Created by anderson on 25/06/2020.
 */
class FeedViewModel @Inject constructor(private val repository: FeedRepository): BaseViewModel(){

    fun feed(token: String, category: String): LiveData<Resouce<DogResponse>> {
        return Transformations.map(repository.feed(token, category)) {
            return@map it
        }
    }
}