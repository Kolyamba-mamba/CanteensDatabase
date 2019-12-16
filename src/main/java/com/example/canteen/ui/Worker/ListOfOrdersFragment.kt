package com.example.canteen.ui.Worker


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.Adapter.ListOfOrdersAdapter
import com.example.canteen.R
import com.example.canteen.ViewModel.ListOfOrdersViewModel

/**
 * A simple [Fragment] subclass.
 */
class ListOfOrdersFragment : Fragment() {

  lateinit var ordersViewModel: ListOfOrdersViewModel
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val fragment = inflater.inflate(R.layout.fragment_list_of_orders, container, false)
    val recyclerView = fragment.findViewById<RecyclerView>(R.id.rvOrders)
    val adapter = ListOfOrdersAdapter(activity)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(context)

    ordersViewModel = ViewModelProvider(this).get(ListOfOrdersViewModel::class.java)

    ordersViewModel.allOrders.observe(viewLifecycleOwner, Observer { orders ->
      orders?.let { adapter.setOrders(it) }
    })


    return fragment
  }


}
