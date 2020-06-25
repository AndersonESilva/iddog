package br.com.anderson.iddog.data.response

import com.google.gson.annotations.SerializedName

/**
 * Created by anderson on 24/06/2020.
 */
data class SignupResponse (
    @SerializedName("email") val email: String?,
    @SerializedName("token") val token: String?
)