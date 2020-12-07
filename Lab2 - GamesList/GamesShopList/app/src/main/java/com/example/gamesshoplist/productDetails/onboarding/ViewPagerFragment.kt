package com.example.gamesshoplist.productDetails.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gamesshoplist.R
import com.example.gamesshoplist.productDetails.onboarding.tabs.DescriptionTab
import com.example.gamesshoplist.productDetails.onboarding.tabs.GaleryTab
import com.example.gamesshoplist.productDetails.onboarding.tabs.RequitmentsTab
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            DescriptionTab(),
            GaleryTab(),
            RequitmentsTab()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            childFragmentManager,
            lifecycle,
        )

        view.view_pager.adapter = adapter

        return view
    }
}
