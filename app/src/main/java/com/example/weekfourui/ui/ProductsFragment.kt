package com.example.weekfourui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.weekfourui.R
import com.example.weekfourui.data.RecyclerViewCardList.Companion.recyclerDataModel
import com.example.weekfourui.data.ViewPagerCardList.Companion.viewPagerDataModel
import com.example.weekfourui.model.ViewPagerModel
import com.example.weekfourui.adapter.RecyclerViewAdapter
import com.example.weekfourui.adapter.ViewPagerAdapter2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.abs

class ProductsFragment : Fragment() {

    private lateinit var adapter: ViewPagerAdapter2
    private lateinit var models: ArrayList<ViewPagerModel>
    private lateinit var viewPager: ViewPager2
    private lateinit var recyclerView: RecyclerView
    private lateinit var sliderDot: TabLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        //create an instance of the class that holds te data to be displayed
        var recyclerListClass = recyclerDataModel()
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter =
            RecyclerViewAdapter(recyclerListClass)


        //create an instance of the view pager model class that holds the list to be displayed
        var viewPagerClass = viewPagerDataModel()
        viewPager = view.findViewById(R.id.view_pager)
        adapter =
            ViewPagerAdapter2(viewPagerClass)
        viewPager.adapter = adapter



        //use a CompositePageTransformer method to add animations the views
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            page.scaleY = 1 - (0.25f * abs(position))
        }



        //attach the transformer to the viewPager
        viewPager.setPageTransformer(compositePageTransformer)
        viewPager.setPadding(100, 0, 100, 0)
        viewPager.clipToPadding = false
        viewPager.adapter = adapter
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER


        //get the id of the tabLayout and put it in a variable
        sliderDot = view.findViewById(R.id.slider_dots)
        TabLayoutMediator(sliderDot, viewPager) { tab, position ->
            viewPager.setCurrentItem(tab.position, true)
        }.attach()

        return view
    }

    //a companion object that creates a new instance of the products fragment
    companion object {
        fun newInstance(): ProductsFragment =
            ProductsFragment()
    }
}