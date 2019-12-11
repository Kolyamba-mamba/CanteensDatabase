package com.example.canteen.ui.Client


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.canteen.R
import kotlinx.android.synthetic.main.fragment_dish.view.*

/**
 * A simple [Fragment] subclass.
 */
class DishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment = inflater.inflate(R.layout.fragment_dish, container, false)

        val dishTitle = arguments!!.getString("dishTitle")
        val dishPrice = arguments!!.getInt("dishPrice")

        fragment.tvTitleDish.text = dishTitle
        fragment.tvPriceDish.text = dishPrice.toString()

        return fragment
    }


}
