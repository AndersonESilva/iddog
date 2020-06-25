package br.com.anderson.iddog.service

import br.com.anderson.iddog.data.request.SignupRequest
import br.com.anderson.iddog.data.response.SignupResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

/**
 * Created by anderson on 24/06/2020.
 */
interface IdwallService {

    @GET("/signup")
    fun signup(@Body signupRequest: SignupRequest): Call<SignupResponse>
}