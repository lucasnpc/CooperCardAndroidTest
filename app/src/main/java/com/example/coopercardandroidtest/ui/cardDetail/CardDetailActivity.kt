package com.example.coopercardandroidtest.ui.cardDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coopercardandroidtest.R
import com.example.coopercardandroidtest.data.model.Card
import com.example.coopercardandroidtest.databinding.ActivityCardDetailBinding
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class CardDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCardDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_card_detail)

        val card = Gson().fromJson(intent.getStringExtra("card").toString(), Card::class.java)

        Picasso.get().load(card.category.image_path).into(binding.imageView)
        binding.tvApelidoDetail.text = card.name
        binding.tvLimitDetail.text = "R$" + card.limit.toString()
        binding.tvCartaoDetail.text = card.card_number

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}