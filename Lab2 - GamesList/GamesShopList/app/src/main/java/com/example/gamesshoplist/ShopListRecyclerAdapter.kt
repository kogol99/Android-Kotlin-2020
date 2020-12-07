package com.example.gamesshoplist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.gamesshoplist.models.Game
import kotlinx.android.synthetic.main.layout_game_list_item.view.*


class ShopListRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: ArrayList<Game> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_game_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BlogViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    fun getGameId(position: Int): Int {
        return items[position].idItem
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(game: ArrayList<Game>){
        items = game
    }

    fun getList(): ArrayList<Game>{
        return items
    }

    fun getFavList(): ArrayList<Game>{
        var favList: ArrayList<Game> = ArrayList()
        for(item in items){
            if(item.isFavorite){
                favList.add(item)
            }
        }
        return favList
    }

    fun removeAt(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }


    class BlogViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        private val gameCover = itemView.IV_cover
        private val gameTitle = itemView.TV_game_title
        private val gamePlatform = itemView.TV_game_platform
        private val gameCategory = itemView.TV_game_category
        private val gamePrice = itemView.TV_game_price
        private val favCardView = itemView.CV_fav
        private val listItem = itemView.CV_list_item

        fun bind(game: Game){
            val requestOption = RequestOptions()
                .placeholder(R.drawable.no_internet)
                .error(R.drawable.no_internet)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOption)
                .load(game.cover)
                .into(gameCover)
            gameTitle.text = game.title
            gamePlatform.text = "${R.string.platform_display_string} ${game.platform}"
            gameCategory.text = "${R.string.category_display_string} ${game.category}"
            gamePrice.text = "${game.price}zł"
            getFavoriteButton(game)
            favCardView.setOnClickListener {
                game.isFavorite = !game.isFavorite
                getFavoriteButton(game)
            }
            listItem.setOnClickListener{
                val productID = game.idItem
                val iDBundle = bundleOf("productID" to productID)
                it.findNavController()
                    .navigate(R.id.action_mainFragment_to_detailsFragment, iDBundle)
            }

        }

        private fun getFavoriteButton(game: Game){
            itemView.apply {
                if (game.isFavorite){
                    TV_fav.setTextColor(Color.parseColor("#FFFFFF"))
                    IV_fav.setImageResource(R.drawable.fav2)
                    CV_fav.setCardBackgroundColor(resources.getColor(R.color.darkGreen))
                    TV_fav.text = context.getString(R.string.is_fav_main_text_button)
                }
                else {
                    TV_fav.setTextColor(resources.getColor(R.color.darkGreen))
                    IV_fav.setImageResource(R.drawable.fav1)
                    CV_fav.setCardBackgroundColor(resources.getColor(R.color.brightGreen))
                    TV_fav.text = context.getString(R.string.not_fav_main_text_button)
                }
            }

        }
    }

}
