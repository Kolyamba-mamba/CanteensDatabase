package com.example.canteen.ui.Client


import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.Adapter.CanteenMenuAdapter
import com.example.canteen.R
import com.example.canteen.ViewModel.MenuViewModel

/**
 * A simple [Fragment] subclass.
 */
class CanteenMenuFragment : Fragment() {

    lateinit var menuViewModel: MenuViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment = inflater.inflate(R.layout.fragment_canteen_menu, container, false)
        val recyclerView = fragment.findViewById<RecyclerView>(R.id.rvMenu)
        val adapter = CanteenMenuAdapter(activity)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        val canteenId = arguments!!.getInt("canteenId")

        val factory = MenuViewModel.MyFactory(requireActivity().application,canteenId)

        menuViewModel = ViewModelProvider(this, factory).get(MenuViewModel::class.java)

        menuViewModel.dishes.observe(viewLifecycleOwner, Observer { dishes ->
            dishes?.let { adapter.setMenu(it) }
        })

        return fragment
    }


}
