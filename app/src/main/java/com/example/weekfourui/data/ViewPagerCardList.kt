package com.example.weekfourui.data

import android.graphics.Color
import com.example.weekfourui.model.ViewPagerModel

class ViewPagerCardList {

    companion object{
        fun viewPagerDataModel(): ArrayList<ViewPagerModel>{

           return arrayListOf(ViewPagerModel(
                "Darot",
                "30,000,000.00",
                Color.RED
            ), ViewPagerModel(
                "Emeka",
                "50,000,000.00",
                Color.BLUE
            ), ViewPagerModel(
                "Dennis",
                "40,000,000.00",
                Color.RED
            ),  ViewPagerModel(
                "Samuel",
                "50,000,000.00",
                Color.DKGRAY
            ),  ViewPagerModel(
                "Dapo",
                "500,000,000.00",
                Color.CYAN
            ))
        }

    }

}