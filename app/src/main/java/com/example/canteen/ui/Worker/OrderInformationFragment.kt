package com.example.canteen.ui.Worker


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.canteen.Entity.Client
import com.example.canteen.R
import com.example.canteen.ViewModel.OrderInfoViewModel
import kotlinx.android.synthetic.main.fragment_order_information.*

/**
 * A simple [Fragment] subclass.
 */
class OrderInformationFragment : Fragment() {

    private lateinit var orderInfoViewModel: OrderInfoViewModel

    private fun fill(data: Client){
        tvFio.text = data.FullName
        tvClientAddress.text = data.Address
        tvClientPhone.text = data.PhoneNumber
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment= inflater.inflate(R.layout.fragment_order_information, container, false)

        val orderId = arguments!!.getInt("orderId")

        val factory = OrderInfoViewModel.MyFactory(requireActivity().application, orderId)

        orderInfoViewModel = ViewModelProvider(this, factory).get(OrderInfoViewModel::class.java)

        orderInfoViewModel.orderInfo.observe(viewLifecycleOwner, Observer { inf ->
            inf?.let {
                fill(it)
            }
        })
        return fragment
    }
}
