package com.example.coopercardandroidtest.ui.cardList

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.coopercardandroidtest.R
import com.example.coopercardandroidtest.data.model.Card
import com.example.coopercardandroidtest.databinding.ActivityCardListBinding
import com.example.coopercardandroidtest.ui.cardDetail.CardDetailActivity
import com.example.coopercardandroidtest.ui.cardList.adapter.CardListAdapter
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardListActivity : AppCompatActivity() {

    private val cardListViewModel: CardListViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityCardListBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_card_list)
        binding.lifecycleOwner = this
        binding.viewModel = cardListViewModel

        cardListViewModel.getCards()

        cardListViewModel.cardListResult.observe(this@CardListActivity, Observer {
            val cardListResult = it ?: return@Observer

            if (cardListResult.success == true) {
                if (cardListResult.cards != null)
                    binding.cardsList.apply {
                        adapter = CardListAdapter(
                            cardList = cardListResult.cards,
                            context = this@CardListActivity,
                            cardItemClick = { card -> cardClick(card) }
                        )
                        addItemDecoration(
                            DividerItemDecoration(
                                this@CardListActivity,
                                DividerItemDecoration.VERTICAL
                            )
                        )
                    }
            }
        })

        binding.reload.setOnClickListener {
            cardListViewModel.getCards()
        }
    }

    /***   Update UI   ***/
    private fun cardClick(card: Card) {
        startActivity(
            Intent(this, CardDetailActivity::class.java).putExtra(
                "card",
                Gson().toJson(card)
            )
        )
    }
}
