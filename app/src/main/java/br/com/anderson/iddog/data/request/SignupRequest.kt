package br.com.anderson.iddog.data.request

import com.google.gson.annotations.SerializedName

/**
 * Created by anderson on 24/06/2020.
 */
data class SignupRequest (
    @SerializedName("email") var email: String
)