package com.home.basics.data.api

import com.home.basics.models.Credentials
import com.home.basics.models.UserData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface IRestfullClient {
    @POST("user/login")
    fun login(
        @Header("PrivateToken") privateToken: String?,
        @Body user: UserData?
    ): Call<List<UserData?>?>

    @POST("auth")
    fun signUp(
        @Header("PrivateToken") privateToken: String?,
        @Body credentials: Credentials?
    ): Call<Credentials?>
}