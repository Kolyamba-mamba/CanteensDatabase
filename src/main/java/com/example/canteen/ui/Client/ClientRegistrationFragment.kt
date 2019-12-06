package com.example.canteen.ui.Client


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.canteen.R
import kotlinx.android.synthetic.main.fragment_client_registration.view.*

/**
 * A simple [Fragment] subclass.
 */
class ClientRegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment = inflater.inflate(R.layout.fragment_client_registration, container, false)

        val navController = NavHostFragment.findNavController(this)

        fragment.btnEnter.setOnClickListener { navController.navigate(R.id.listOfCanteens)}

        return fragment
    }


}
