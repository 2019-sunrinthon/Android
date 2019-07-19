package com.jjmin.sunrinthon.data

import com.jjmin.sunrinthon.data.model.LoginData
import com.jjmin.sunrinthon.data.model.SignUpData
import io.reactivex.Single

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NetworkApi {

    @FormUrlEncoded
    @POST("/v1/auth/token")
    fun Login(@Field("provider") provider : String,@Field("email") email : String, @Field("password") password : String) : Single<LoginData>

    @FormUrlEncoded
    @POST("/v1/user")
    fun SignUp(@Field("username") username : String,@Field("password") password: String,
               @Field("name") name : String,@Field("email") email : String,
               @Field("phoneNumber") phoneNumber : String,@Field("age") age : Int) : Single<SignUpData>
}