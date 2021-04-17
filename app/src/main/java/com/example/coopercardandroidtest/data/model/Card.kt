package com.example.coopercardandroidtest.data.model

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("name")
    val name: String,
    @SerializedName("card_number")
    val card_number: String,
    @SerializedName("limit")
    val limit: Double,
    @SerializedName("category")
    val category: CardCategory

)
data class CardCategory(
    @SerializedName("type")
    val type: String,
    @SerializedName("background_color")
    val background_color: String,
    @SerializedName("image_path")
    val image_path: String
)