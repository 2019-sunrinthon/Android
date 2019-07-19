package com.jjmin.sunrinthon.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

data class LoginData(
    @SerializedName("token")
    var token: String = "",
    @SerializedName("success")
    var success: Boolean = false,
    @SerializedName("username")
    var username: String = "",
    @SerializedName("email")
    var email: String = "",
    @SerializedName("phoneNumber")
    var phoneNumber: String = "",
    @SerializedName("age")
    var age: String = ""
)