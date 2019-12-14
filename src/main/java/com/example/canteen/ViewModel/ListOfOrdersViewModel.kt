package com.example.canteen.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.canteen.Database.AppDatabase
import com.example.canteen.Entity.Order
import com.example.canteen.Repository.ListOfOrdersRepository
import kotlinx.coroutines.launch

class ListOfOrdersViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ListOfOrdersRepository
    val allOrders: LiveData<List<Order>>

    init {
        val orderDao = AppDatabase.getDatabase(application, viewModelScope).orderDao()
        repository = ListOfOrdersRepository(orderDao)
        allOrders = repository.allOrders
    }

    fun insert(order: Order) = viewModelScope.launch {
        repository.insert(order)
    }
}