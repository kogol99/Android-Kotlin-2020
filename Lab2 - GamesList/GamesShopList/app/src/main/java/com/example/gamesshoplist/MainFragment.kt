package com.example.gamesshoplist

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesshoplist.models.Game
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var listAdapter: ShopListRecyclerAdapter
    private var favouritesIdList: ArrayList<String> = ArrayList()
    private var favouritesList: ArrayList<Game> = ArrayList()
    private var safeRecyclerList: ArrayList<Game> = ArrayList()
    private var isActiveFilterPc: Boolean = false
    private var isActiveFilterPs4: Boolean = false
    private var isActiveFilterXone: Boolean = false
    private var isActiveFilterFav: Boolean = false

    //@TODO
    //@do zrobienia zapisywanie w sesji danej tablicy

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        addDataSet()
        checkEmptyListToVisibilityList()

        B_filtr_pc.setOnClickListener{
            showFiltr("PC")
        }
        B_filtr_ps4.setOnClickListener{
            showFiltr("PS4")
        }
        B_filtr_xone.setOnClickListener{
            showFiltr("Xone")
        }
        B_filtr_fav.setOnClickListener{
            showFiltr("Fav")
        }
    }


    private fun showFiltr(filtrName: String){
        var isActiveFilter = isActiveFilterPc
        var buttonResource = B_filtr_pc
        when (filtrName) {
            "PS4" -> {
                isActiveFilter = isActiveFilterPs4
                buttonResource = B_filtr_ps4
            }
            "Xone" -> {
                isActiveFilter = isActiveFilterXone
                buttonResource = B_filtr_xone
            }
            "Fav" -> {
                isActiveFilter = isActiveFilterFav
                buttonResource = B_filtr_fav
            }
        }

        if(isActiveFilterPc || isActiveFilterPs4 || isActiveFilterXone || isActiveFilterFav){
            isActiveFilterPc = false
            isActiveFilterPs4 = false
            isActiveFilterXone = false
            isActiveFilterFav = false
            addNewListToAdapter(safeRecyclerList)
            deColorAllFiltrButton()
        }
        when {
            isActiveFilter -> {
                isActiveFilter = false

            }
            filtrName == "Fav" -> {
                safeRecyclerList = listAdapter.getList()
                isActiveFilter = true
                addNewListToAdapter(listAdapter.getFavList())
                buttonResource.setTextColor(Color.parseColor("#FFFFFF"))
                buttonResource.setBackgroundResource(R.drawable.button_circle_corner_active)
            }
            else -> {
                val actualList = listAdapter.getList()
                safeRecyclerList = actualList
                isActiveFilter = true
                val newList = ArrayList<Game>()
                for(item in actualList){
                    if(item.platform == filtrName){
                        newList.add(item)
                    }
                }
                addNewListToAdapter(newList)
                buttonResource.setTextColor(Color.parseColor("#FFFFFF"))
                buttonResource.setBackgroundResource(R.drawable.button_circle_corner_active) }
        }
        when (filtrName) {
            "PC" -> {
                isActiveFilterPc = isActiveFilter
            }
            "PS4" -> {
                isActiveFilterPs4 = isActiveFilter
            }
            "Xone" -> {
                isActiveFilterXone = isActiveFilter
            }
            "Fav" -> {
                isActiveFilterFav = isActiveFilter
            }
        }
    }

    private fun checkEmptyListToVisibilityList(){
        if(listAdapter.getList().isEmpty()){
            getInvisibleRecycler()
        } else {
            getVisibleRecycler()
        }
    }

    private fun deleteItemFromList(id: Int){
        var position: Int = 0
        for(item in safeRecyclerList){
            if(item.idItem == id){
                safeRecyclerList.removeAt(position)
                return
            }
            position++
        }
    }

    private fun addNewListToAdapter(newList: ArrayList<Game>){
        recycler_view.apply {
            listAdapter.submitList(newList)
            recycler_view.adapter = listAdapter
        }
        checkEmptyListToVisibilityList()
    }

    private fun getInvisibleRecycler(){
        IV_recycle_empty.visibility = View.VISIBLE
        TV_recycle_empty.visibility = View.VISIBLE
        recycler_view.visibility = View.INVISIBLE
    }

    private fun getVisibleRecycler(){
        IV_recycle_empty.visibility = View.INVISIBLE
        TV_recycle_empty.visibility = View.INVISIBLE
        recycler_view.visibility = View.VISIBLE
    }


    private fun deColorAllFiltrButton() {
        B_filtr_pc.setTextColor(Color.parseColor("#000000"))
        B_filtr_pc.setBackgroundResource(R.drawable.button_circle_corner)
        B_filtr_ps4.setTextColor(Color.parseColor("#000000"))
        B_filtr_ps4.setBackgroundResource(R.drawable.button_circle_corner)
        B_filtr_xone.setTextColor(Color.parseColor("#000000"))
        B_filtr_xone.setBackgroundResource(R.drawable.button_circle_corner)
        B_filtr_fav.setTextColor(Color.parseColor("#000000"))
        B_filtr_fav.setBackgroundResource(R.drawable.button_circle_corner)
    }


    private fun addDataSet() {
        val data = DataSource.createDataSet()
        listAdapter.submitList(data)
    }


    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            listAdapter = ShopListRecyclerAdapter()
            recycler_view.adapter = listAdapter
        }

        val swipeHandler = object : SwipeToDeleteCallback(recycler_view.context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position: Int = viewHolder.adapterPosition
                val idItem: Int = listAdapter.getGameId(position)
                deleteItemFromList(idItem)
                val adapter = recycler_view.adapter as ShopListRecyclerAdapter
                adapter.removeAt(position)
                if(listAdapter.getList().isEmpty()){
                    getInvisibleRecycler()
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recycler_view)

    }

}
