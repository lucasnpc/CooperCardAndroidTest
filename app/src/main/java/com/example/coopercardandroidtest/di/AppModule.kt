package com.example.coopercardandroidtest.di

import com.example.coopercardandroidtest.data.CardListRepository
import com.example.coopercardandroidtest.ui.cardList.CardListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cardListModule = module {
    factory { CardListRepository() }
    viewModel { CardListViewModel(cardListRepository = get()) }
}