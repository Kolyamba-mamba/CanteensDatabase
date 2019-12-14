package com.example.canteen.ui.Client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.Adapter.BasketAdapter
import com.example.canteen.BasketSingleton
import com.example.canteen.R
import com.example.canteen.ViewModel.BasketViewModel
import kotlinx.android.synthetic.main.fragment_basket.view.*
import kotlinx.android.synthetic.main.fragment_dish.view.*

class BasketFragment : Fragment() {

    private lateinit var basketViewModel: BasketViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragment = inflater.inflate(R.layout.fragment_basket, container, false)
        val recyclerView = fragment.findViewById<RecyclerView>(R.id.rvListInBasket)
        val adapter = BasketAdapter(activity)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)



        if(BasketSingleton.arrayOfDishId.size > 0){
            basketViewModel = ViewModelProvider(this).get(BasketViewModel::class.java)

            basketViewModel.dishes.observe(viewLifecycleOwner, Observer { dishes ->
                dishes?.let { adapter.setDishInBasket(it) }
            })

            fragment.btGoToOrderRegistration.visibility = View.VISIBLE
            fragment.tvBasketIsNull.visibility = View.GONE
        }
        else{
            fragment.btGoToOrderRegistration.visibility = View.GONE
            fragment.tvBasketIsNull.visibility = View.VISIBLE
        }

        return fragment
    }
}