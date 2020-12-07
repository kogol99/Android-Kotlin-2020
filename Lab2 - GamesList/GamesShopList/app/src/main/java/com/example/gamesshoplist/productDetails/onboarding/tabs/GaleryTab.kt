package com.example.gamesshoplist.productDetails.onboarding.tabs

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.gamesshoplist.DataSource
import com.example.gamesshoplist.MainActivity
import com.example.gamesshoplist.R
import com.example.gamesshoplist.productDetails.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_second_screen.*
import kotlinx.android.synthetic.main.fragment_second_screen.view.*

class GaleryTab : Fragment() {

    private var productID: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second_screen, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        view.TV_decr_second_screen.setOnClickListener{
            viewPager?.setCurrentItem(0,  false)
        }

        view.TV_galery_second_screen.setOnClickListener{
            viewPager?.setCurrentItem(1,  false)
        }

        view.TV_details_second_screen.setOnClickListener{
            viewPager?.setCurrentItem(2,  false)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productID = DetailsViewModel.productID
        val gameInfoObject = DataSource.getObjectById(productID)
        Glide.with(requireContext())
            .load(gameInfoObject?.image1)
            .into(IV_second_screen_one)

        Glide.with(requireContext())
            .load(gameInfoObject?.image2)
            .into(IV_second_screen_two)

        Glide.with(requireContext())
            .load(gameInfoObject?.image3)
            .into(IV_second_screen_three)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    startActivity(Intent(context, MainActivity::class.java ))
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }
}
