package com.example.coopercardandroidtest.ui.cardList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coopercardandroidtest.R
import com.example.coopercardandroidtest.data.model.Card
import com.example.coopercardandroidtest.data.model.Cards
import com.example.coopercardandroidtest.databinding.CardCardsModelBinding
import com.example.coopercardandroidtest.ui.cardList.CardListActivity
import com.squareup.picasso.Picasso

class CardListAdapter(
    private val cardItemClick: (Card) -> Unit,
    private val context: CardListActivity,
    private val cardList: Cards
) :
    RecyclerView.Adapter<CardListAdapter.CardListViewHolder>() {
    inner class CardListViewHolder(@NonNull val binding: CardCardsModelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setCardClick(card: Card) {
            binding.cardCards.setOnClickListener { cardItemClick(card) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardListViewHolder =
        CardListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.card_cards_model,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: CardListViewHolder, position: Int) {
        val card = cardList.cards[position]

        Picasso.get().load(card.category.image_path).into(holder.binding.imgPath)
        holder.binding.tvName.text = card.name
        holder.binding.tvCardNumber.text = "**** " + card.card_number
        holder.binding.tvLimit.text = "R$" + card.limit.toString()

        holder.setCardClick(card)
    }

    override fun getItemCount() = cardList.cards.size
}