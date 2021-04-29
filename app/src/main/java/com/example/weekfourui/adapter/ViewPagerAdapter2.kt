package com.example.weekfourui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.weekfourui.R
import com.example.weekfourui.model.ViewPagerModel
import kotlinx.android.synthetic.main.card_view_item.view.*

class ViewPagerAdapter2(private val models: ArrayList<ViewPagerModel>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)

        return RecyclerViewAdapter.ViewHolder(mView)
    }

    //method to get the size of the list and return it
    override fun getItemCount(): Int {
        return models.size
    }

    //method to bind the items in the list to the layout
    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.itemView.apply {
            debit_card_name.text = models[position].name
            debit_card_amount.text = models[position].amount
            card_view_ll.setBackgroundColor(models[position].color)

            //attach an animation to the viewPager item
            holder.itemView.animation = AnimationUtils.loadAnimation(
                context,
                R.anim.zoom_in
            )

        }
    }


}