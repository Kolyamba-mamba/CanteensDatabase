package com.example.canteen.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.Entity.Dish
import com.example.canteen.R
import kotlinx.android.synthetic.main.dish_list_item.view.*

class CanteenMenuAdapter internal constructor(val context: FragmentActivity?):
  RecyclerView.Adapter<CanteenMenuAdapter.ViewHolder>(){

  private val inflater = LayoutInflater.from(context)
  private var menu = emptyList<Dish>()

  override fun getItemCount(): Int = menu.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      inflater.inflate(R.layout.dish_list_item, parent, false)
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.itemView.setOnClickListener{view ->
      view.findNavController().navigate(R.id.dishFragment)
      print(menu[position].Id)
    }
    holder.title.text = menu[position].Title
    holder.price.text = menu[position].Price.toString()

  }

  inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val title: TextView = view.tvTitleDish
    val price: TextView = view.tvPriceDish
  }

  fun setMenu(dishes: List<Dish>){
    this.menu = dishes
    notifyDataSetChanged()
  }
}