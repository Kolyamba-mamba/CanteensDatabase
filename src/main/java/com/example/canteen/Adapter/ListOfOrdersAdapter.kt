package com.example.canteen.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.Entity.Order
import com.example.canteen.R
import kotlinx.android.synthetic.main.orders_list_item.view.*

class ListOfOrdersAdapter internal constructor(val context: FragmentActivity?):
    RecyclerView.Adapter<ListOfOrdersAdapter.OrderViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private var orders = emptyList<Order>()

    override fun getItemCount(): Int = orders.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderViewHolder {
        return OrderViewHolder(
            inflater.inflate(R.layout.orders_list_item,parent,false)
        )
    }


    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.orderNumber.text = orders[position].Id.toString()
        holder.orderTime.text = orders[position].OrderTime
    }

    inner class OrderViewHolder(view: View): RecyclerView.ViewHolder(view){
        val orderNumber: TextView = view.tvOrderNumber
        val orderTime: TextView = view.tvTime
    }

}