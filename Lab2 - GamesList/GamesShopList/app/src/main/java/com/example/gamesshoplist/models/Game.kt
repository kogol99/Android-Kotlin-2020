package com.example.gamesshoplist.models

data class Game(
    var idItem: Int,
    var title: String,
    var category: String,
    var platform: String,
    var cover: String,
    var image1: String,
    var image2: String,
    var image3: String,
    var description: String,
    var minimalRequirments: String,
    var recommendedRequirments: String,
    var price: String,
    var isFavorite: Boolean
)