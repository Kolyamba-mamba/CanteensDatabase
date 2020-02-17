package com.example.canteen.ViewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.canteen.Database.AppDatabase
import com.example.canteen.Entity.Client
import com.example.canteen.Repository.OrderInfoRepository

class OrderInfoViewModel(application: Application, orderId: Int): AndroidViewModel(application) {
    private val repository: OrderInfoRepository
    val orderInfo: LiveData<Client>

    init {
        val orderDao = AppDatabase.getDatabase(application, viewModelScope).orderDao()
        repository = OrderInfoRepository(orderDao,orderId)
        orderInfo = repository.clientInfo
        println(orderInfo)
    }

    class MyFactory(val application: Application, val arg: Int): ViewModelProvider.NewInstanceFactory(){
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return OrderInfoViewModel(application, arg) as T
        }
    }
}