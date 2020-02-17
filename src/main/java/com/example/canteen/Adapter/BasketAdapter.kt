package com.example.canteen.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.Entity.Dish
import com.example.canteen.R
import kotlinx.android.synthetic.main.dish_list_item.view.*

class BasketAdapter internal constructor(val context: FragmentActivity?):
    RecyclerView.Adapter<BasketAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private var dishInBasket = emptyList<Dish>()

    override fun getItemCount(): Int = dishInBasket.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            inflater.inflate(R.layout.dish_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = dishInBasket[position].Title
        holder.price.text = dishInBasket[position].Price.toString()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title: TextView = view.tvTitleDish
        val price: TextView = view.tvPriceDish
    }

    fun setDishInBasket(dishes: List<Dish>){
        this.dishInBasket = dishes
        notifyDataSetChanged()
    }
}