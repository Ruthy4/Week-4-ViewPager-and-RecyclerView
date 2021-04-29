package com.example.weekfourui.data

import com.example.weekfourui.R
import com.example.weekfourui.model.RecyclerViewModel

class RecyclerViewCardList {

    companion object{

    fun recyclerDataModel(): ArrayList<RecyclerViewModel> {


       // return the list with the added items
        return arrayListOf(
            RecyclerViewModel(
                "Aliexpress",
                "from 4%",
                "Clothes and shoes",
                R.drawable.ic_shopping_bag),
            RecyclerViewModel(
                "Aviasales",
                "from 4.4%",
                "Tickets and Travels",
                R.drawable.ic_blue_shopping_bag
            ),
            RecyclerViewModel(
                "Bookgram",
                "from 4%",
                "Booking and Scheduling",
                R.drawable.ic_shopping_bag
            ),
            RecyclerViewModel(
                "Jumia",
                "from 10%",
                "Phones and Accessories",
                R.drawable.ic_blue_shopping_bag
            ),
            RecyclerViewModel(
                "Konga",
                "from 3%",
                "Jewelries",
                R.drawable.ic_shopping_bag
            )
        )

    }
}}