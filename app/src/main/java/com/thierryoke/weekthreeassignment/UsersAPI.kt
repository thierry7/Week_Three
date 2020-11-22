package com.thierryoke.weekthreeassignment

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface UsersAPI {

    @GET("search/users")
        fun searchRepos(@Query("q") searchTerm: String): Call<Base>

    @GET("users/{username}")
    fun searchReposNumber(@Path("username")username: String):Call<UserInfos>

    @GET("users/{username}/followers")
    fun searchFollowers(@Path("username")username: String):Call<List<followers>>

    @GET("users/{username}/followers")
    fun searchFollowing(@Path("username")username: String):Call<List<following>>

    companion object{
        fun initretrofit(): UsersAPI {
            return Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(UsersAPI::class.java)
        }
    }


}