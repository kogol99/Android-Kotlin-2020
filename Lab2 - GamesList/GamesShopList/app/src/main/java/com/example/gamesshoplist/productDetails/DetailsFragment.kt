package com.example.gamesshoplist.productDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.gamesshoplist.DataSource
import com.example.gamesshoplist.R
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {
    private lateinit var viewModel: DetailsViewModel
    private lateinit var fragmentView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.fragment_details, container, false)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val gameInfoObject = DataSource.getObjectById(viewModel.getID())
        TV_title.text = gameInfoObject?.title
        TV_category.text = "${getString(R.string.game_category)} ${gameInfoObject?.category}"
        TV_platform.text = "${getString(R.string.game_platform)} ${gameInfoObject?.platform}"
        TV_cost.text = "${gameInfoObject?.price} ${getString(R.string.currency)}"
        Glide.with(requireContext())
            .load(gameInfoObject?.image1)
            .into(IV_background_image)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_detailsFragment_to_mainFragment2)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        viewModel.setID(requireArguments().getInt("productID"))
    }
}
