package com.example.zadanie2350_adapterdelegates.adapter

import com.example.zadanie2350_adapterdelegates.model.Item
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ProductAdapter(items: List<Item>) : ListDelegationAdapter <List<Item>> ()  {

    init {
        delegatesManager.addDelegate(ProductDelegateAdapter())
        delegatesManager.addDelegate(AdDelegateAdapter())

        setItems(items)
    }

    override fun setItems(items: List < Item > ? ) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}


