package com.example.canteen.ui.Client


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.Adapter.ListOfCanteensAdapter
import com.example.canteen.R
import com.example.canteen.ViewModel.CanteenViewModel

/**
 * A simple [Fragment] subclass.
 */
class ListOfCanteensFragment : Fragment() {

    private lateinit var canteenViewModel: CanteenViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragment = inflater.inflate(R.layout.fragment_list_of_canteens, container, false)
        val recyclerView = fragment.findViewById<RecyclerView>(R.id.rvCanteens)
        val adapter = ListOfCanteensAdapter(activity)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        canteenViewModel = ViewModelProvider(this).get(CanteenViewModel::class.java)

        canteenViewModel.allCanteens.observe(viewLifecycleOwner, Observer { canteens ->
            canteens?.let {
                adapter.setCanteens(it)
            }
        })

        return fragment
    }


}
