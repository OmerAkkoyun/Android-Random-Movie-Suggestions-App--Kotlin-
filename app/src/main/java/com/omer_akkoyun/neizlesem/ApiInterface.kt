package com.omer_akkoyun.neizlesem

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("api/movie_details.json?")

    fun filmiGetir(@Query("movie_id") filmID:Int):retrofit2.Call<DataModelClass>


}