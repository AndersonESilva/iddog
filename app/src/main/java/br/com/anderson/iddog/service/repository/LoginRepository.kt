package br.com.anderson.iddog.service.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.anderson.iddog.data.request.SignupRequest
import br.com.anderson.iddog.data.response.SignupResponse
import br.com.anderson.iddog.service.IdwallService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by anderson on 24/06/2020.
 */
class LoginRepository @Inject constructor(private val service: IdwallService){

    fun signup(email: String): MutableLiveData<SignupResponse>{
        var data = MutableLiveData<SignupResponse>()

        service.signup(SignupRequest(email)).enqueue(object : Callback<SignupResponse> {
            override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                data.value = null
                Log.e("SIGNUP ERROR", t.message)
            }

            override fun onResponse(call: Call<SignupResponse>, response: Response<SignupResponse>) {
                data.value = response.body()
            }

        })
        return data
    }
}