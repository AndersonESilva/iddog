package br.com.anderson.iddog.service.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.anderson.iddog.data.response.DogResponse
import br.com.anderson.iddog.data.response.Resouce
import br.com.anderson.iddog.service.IdwallService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by anderson on 26/06/2020.
 */
class FeedRepository @Inject constructor(private val service: IdwallService){

    fun feed(token: String, category: String): MutableLiveData<Resouce<DogResponse>> {
        var data = MutableLiveData<Resouce<DogResponse>>()

        service.feed(token, category).enqueue(object : Callback<DogResponse> {
            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                data.value = Resouce(null, t.message)
                Log.e("SIGNUP ERROR", t.message)
            }

            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                data.value = Resouce(response.body(), null)
            }

        })
        return data
    }
}