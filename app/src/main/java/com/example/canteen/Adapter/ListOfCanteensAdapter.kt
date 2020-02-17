package com.example.canteen.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.Entity.Canteen
import com.example.canteen.R
import kotlinx.android.synthetic.main.canteen_list_item.view.*
import androidx.navigation.findNavController

class ListOfCanteensAdapter internal constructor(val context: FragmentActivity?): RecyclerView.Adapter<ListOfCanteensAdapter.MyViewHolder>() {

  private val inflater = LayoutInflater.from(context)
  private var canteens = emptyList<Canteen>()

  override fun getItemCount(): Int = canteens.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    return MyViewHolder(
      inflater.inflate(R.layout.canteen_list_item, parent, false)
    )
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.itemView.setOnClickListener {view ->
      val bundle = Bundle()
      bundle.putInt("canteenId", canteens[position].Id!!)
      view.findNavController().navigate(R.id.canteenMenu, bundle)
    }

    holder.title.text = canteens[position].Title
    holder.phoneNumber.text = canteens[position].PhoneNumber
    holder.address.text = canteens[position].Address
    holder.workingTime.text = canteens[position].WorkingHours
  }


  inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
    val title: TextView = view.tvTitleCanteen
    val phoneNumber: TextView = view.tvPhoneNumberCanteen
    val address: TextView = view.tvAddressCanteen
    val workingTime: TextView = view.tvTimeCanteen
  }

  fun setCanteens(canteen: List<Canteen>){
    this.canteens = canteen
    notifyDataSetChanged()
  }
}