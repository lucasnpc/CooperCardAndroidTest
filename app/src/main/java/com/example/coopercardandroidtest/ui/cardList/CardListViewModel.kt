package com.example.coopercardandroidtest.ui.cardList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coopercardandroidtest.data.CardListRepository

class CardListViewModel(private val cardListRepository: CardListRepository) : ViewModel() {
    private val _cardListState = MutableLiveData<CardListState>()
    val cardListState: LiveData<CardListState> = _cardListState

    private val _cardListResult = MutableLiveData<CardListResult>()
    val cardListResult: LiveData<CardListResult> = _cardListResult

    fun getCards() {
        _cardListState.value = CardListState(isLoading = true)
        _cardListResult.value = CardListResult(failed = false)
        cardListRepository.getCards(result = _cardListResult, state = _cardListState)
    }
}