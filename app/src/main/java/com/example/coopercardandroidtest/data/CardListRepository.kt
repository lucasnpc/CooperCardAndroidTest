package com.example.coopercardandroidtest.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.coopercardandroidtest.data.model.Cards
import com.example.coopercardandroidtest.data.retrofit.Client
import com.example.coopercardandroidtest.ui.cardList.CardListResult
import com.example.coopercardandroidtest.ui.cardList.CardListState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardListRepository {
    fun getCards(result: MutableLiveData<CardListResult>, state: MutableLiveData<CardListState>) =
        Client().getApi().getCards().enqueue(object : Callback<Cards> {
            override fun onResponse(
                call: Call<Cards>,
                response: Response<Cards>
            ) {
                if (response.code() != 200) {
                    result.value = CardListResult(failed = true)
                    state.value = CardListState(isLoading = false)
                    return
                }
                result.value = CardListResult(success = true, cards = response.body())
                state.value = CardListState(isLoading = false)
                Log.i("Responde", result.value!!.cards.toString())
            }

            override fun onFailure(call: Call<Cards>, t: Throwable) {
                result.value = CardListResult(failed = true)
                state.value = CardListState(isLoading = false)
                Log.e("Error", "get cards request failed")
            }
        })
}