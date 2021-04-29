package com.example.weekfourui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.weekfourui.R
import com.example.weekfourui.model.RecyclerViewModel
import kotlinx.android.synthetic.main.partner_item.view.*

class RecyclerViewAdapter(private val recyclerViewModelList: ArrayList<RecyclerViewModel>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

    //creates the the viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.partner_item, parent, false)

        return ViewHolder(
            view
        )
    }

    //get the size of the list
    override fun getItemCount(): Int {
        return recyclerViewModelList.size
    }

    //method to bind the list with the viewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.apply {

            partner_name.text = recyclerViewModelList[position].partnerName
            percent_text_view.text = recyclerViewModelList[position].percent
            shop_items_text_view.text = recyclerViewModelList[position].items
            shopping_bag_image.setImageResource(recyclerViewModelList[position].image)

            holder.itemView.animation = AnimationUtils.loadAnimation(
                context,
                R.anim.zoom_in
            )

        }


    }

}