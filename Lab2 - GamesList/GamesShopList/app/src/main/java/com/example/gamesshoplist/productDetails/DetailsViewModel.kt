package com.example.gamesshoplist.productDetails

import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {
    companion object {
        var productID: Int = -1
    }

    fun getID(): Int {
        return productID
    }

    fun setID(id: Int) {
        productID = id
    }
}
