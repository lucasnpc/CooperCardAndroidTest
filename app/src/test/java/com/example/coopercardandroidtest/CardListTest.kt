package com.example.coopercardandroidtest

import com.example.coopercardandroidtest.data.model.Cards
import com.example.coopercardandroidtest.data.retrofit.Client
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.spy
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardListTest {
    @Before
    fun setUpMockito() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun isGettingCardList() {
        val client = Client().getApi()

        val call = client.getCards()

        val spy = spy(call)

        spy.enqueue(object : Callback<Cards> {
            override fun onResponse(call: Call<Cards>, response: Response<Cards>) {
                assert(response.body() != null)
            }

            override fun onFailure(call: Call<Cards>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}