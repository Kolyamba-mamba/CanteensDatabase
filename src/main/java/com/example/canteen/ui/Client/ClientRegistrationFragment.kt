package com.example.canteen.ui.Client


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.example.canteen.R
import kotlinx.android.synthetic.main.fragment_client_registration.*
import kotlinx.android.synthetic.main.fragment_client_registration.view.*

/**
 * A simple [Fragment] subclass.
 */
class ClientRegistrationFragment : Fragment() {

    private lateinit var FIO: String
    private lateinit var PhoneNumber: String
    private lateinit var Address: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment = inflater.inflate(R.layout.fragment_client_registration, container, false)
        val navController = NavHostFragment.findNavController(this)

        val regFIO = Regex("^[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{0,}\\s[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{1,}(\\s[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{1,})?\$")
        val regPhone = Regex("^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?\$")

        var toast: Toast

        fragment.btnEnter.setOnClickListener {
            FIO = etFIO.text.toString()
            PhoneNumber = etPhone.text.toString()
            Address = etAddress.text.toString()
            if(regFIO.matches(FIO) and regPhone.matches(PhoneNumber) and Address.isNotEmpty()){
                toast = Toast.makeText(context, "Ваш заказ оформлен",Toast.LENGTH_LONG)
                toast.show()
                navController.navigate(R.id.listOfCanteens)
            }
            else {
                toast = Toast.makeText(context, "Проверьте правильность ввода данных",
                    Toast.LENGTH_LONG)
                toast.show()
            }
        }

        return fragment
    }


}
