package com.example.gamesshoplist.productDetails.onboarding.tabs

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.example.gamesshoplist.DataSource
import com.example.gamesshoplist.MainActivity
import com.example.gamesshoplist.R
import com.example.gamesshoplist.productDetails.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_third_screen.view.*

class RequitmentsTab : Fragment() {

    private var productID: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_third_screen, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        view.TV_descr_third_screen.setOnClickListener{
            viewPager?.setCurrentItem(0,  false)
        }

        view.TV_galery_third_screen.setOnClickListener{
            viewPager?.setCurrentItem(1,  false)
        }

        view.TV_details_third_screen.setOnClickListener{
            viewPager?.setCurrentItem(2,  false)
        }

        return view
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productID = DetailsViewModel.productID
        val gameInfoObject = DataSource.getObjectById(productID)

        view.TV_minimal_req.text = gameInfoObject?.minimalRequirments
        view.TV_recommended_req.text = gameInfoObject?.recommendedRequirments
    }
}
