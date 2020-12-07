package com.example.gamesshoplist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gamesshoplist.models.Game

class MainViewModel: ViewModel() {
    private var productList: ArrayList<Game> = DataSource.createDataSet()

    fun removeProduct(productItem: Game) {
        productList.remove(productItem)
    }

    fun getProductList(): ArrayList<Game> {
        return productList
    }

    fun setProductList(shownCars: ArrayList<Game>) {
        productList = shownCars
    }
}