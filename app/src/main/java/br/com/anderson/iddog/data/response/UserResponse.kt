package br.com.anderson.iddog.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by anderson on 24/06/2020.
 */
@Parcelize
data  class UserResponse (
    @SerializedName("email") val email: String?,
    @SerializedName("token") val token: String?
): Parcelable