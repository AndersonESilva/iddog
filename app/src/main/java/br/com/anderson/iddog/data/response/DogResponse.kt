package br.com.anderson.iddog.data.response

import com.google.gson.annotations.SerializedName

/**
 * Created by anderson on 26/06/2020.
 */
data class DogResponse (
    @SerializedName("category") val category: String?,
    @SerializedName("list") val listUrl: List<String>
)