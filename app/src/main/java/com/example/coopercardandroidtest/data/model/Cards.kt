package com.example.coopercardandroidtest.data.model

import com.google.gson.annotations.SerializedName

data class Cards(
    @SerializedName("cards")
    val cards: ArrayList<Card>
)