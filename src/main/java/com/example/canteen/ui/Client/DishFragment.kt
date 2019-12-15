package com.example.canteen.ui.Client


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.canteen.BasketSingleton
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

        var toast: Toast

        val dishTitle = arguments!!.getString("dishTitle")
        val dishPrice = arguments!!.getInt("dishPrice")
        val dishId = arguments!!.getInt("dishId")

        fragment.tvTitleDish.text = dishTitle
        fragment.tvPriceDish.text = dishPrice.toString()

        fragment.btnAddToBasket.setOnClickListener{
            BasketSingleton.arrayOfDishId.add(dishId)
            toast = Toast.makeText(context, "Блюдо добвалено в корзину!\n" +
                    "Блюд в корзине:  ${BasketSingleton.arrayOfDishId.size}.",Toast.LENGTH_LONG)
            toast.show()
        }

        return fragment
    }


}
