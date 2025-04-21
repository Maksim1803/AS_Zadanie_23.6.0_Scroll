package com.example.zadanie2350_adapterdelegates.model

import androidx.annotation.DrawableRes

class Product(val id: Int, @DrawableRes val idIcon: Int, val name: String, val desc: String) : Item