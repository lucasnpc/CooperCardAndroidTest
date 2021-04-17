package com.example.coopercardandroidtest.ui.cardList

import com.example.coopercardandroidtest.data.model.Cards

data class CardListResult(
    val success: Boolean? = false,
    val failed: Boolean? = false,
    val cards: Cards? = null
)