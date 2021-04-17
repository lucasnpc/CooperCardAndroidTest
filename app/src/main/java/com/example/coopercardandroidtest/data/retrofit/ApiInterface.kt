package com.example.coopercardandroidtest.data.retrofit

import com.example.coopercardandroidtest.data.model.Cards
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("cards.json")
    fun getCards(): Call<Cards>
}