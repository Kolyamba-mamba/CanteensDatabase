package com.example.canteen.ui.Client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.canteen.BasketSingleton
import com.example.canteen.Entity.Client
import com.example.canteen.Entity.Order
import com.example.canteen.R
import com.example.canteen.ViewModel.ClientViewModel
import com.example.canteen.ViewModel.ListOfOrdersViewModel
import kotlinx.android.synthetic.main.fragment_client_registration.*
import kotlinx.android.synthetic.main.fragment_client_registration.view.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */

class ClientRegistrationForm(fragment: ClientRegistrationFragment) {
    var FIO: String
    var PhoneNumber: String
    var Address: String

    companion object {
        val regFIO =
            Regex("^[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{0,}\\s[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{1,}(\\s[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{1,})?\$")
        val regPhone = Regex("^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?\$")
    }
    init {
        FIO = fragment.etFIO.text.toString()
        PhoneNumber = fragment.etPhone.text.toString()
        Address = fragment.etAddress.text.toString()
        if(regFIO.matches(FIO) and regPhone.matches(PhoneNumber) and Address.isNotEmpty())
        {}
        else {
            throw Exception("Error validate")
        }
    }
}

class ClientRegistrationFragment : Fragment() {
    private lateinit var clientViewModel: ClientViewModel
    lateinit var orderViewModel: ListOfOrdersViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment = inflater.inflate(R.layout.fragment_client_registration, container, false)
        val navController = NavHostFragment.findNavController(this)
        var toast: Toast

        clientViewModel = ViewModelProvider(this).get(ClientViewModel::class.java)
        orderViewModel = ViewModelProvider(this).get(ListOfOrdersViewModel::class.java)

        fragment.btnEnter.setOnClickListener {
            try {
                val info = ClientRegistrationForm(this)
                val date = Date()
                val formatter = SimpleDateFormat.getTimeInstance()
                val person = Client(FullName = info.FIO, PhoneNumber = info.PhoneNumber, Address = info.Address)
                val clientId = clientViewModel.insert(person)
                val order = Order(OrderTime = formatter.format(date), Client_Id = clientId.toInt())
                orderViewModel.insert(order)
                toast = Toast.makeText(context, "Ваш заказ оформлен",Toast.LENGTH_LONG)
                toast.show()
                BasketSingleton.arrayOfDishId.clear()
                navController.navigate(R.id.listOfCanteens)
            }
            catch (e: Exception) {
                toast = Toast.makeText(context, "Проверьте правильность ввода данных",
                    Toast.LENGTH_LONG)
                toast.show()
            }
        }
        return fragment
    }
}
