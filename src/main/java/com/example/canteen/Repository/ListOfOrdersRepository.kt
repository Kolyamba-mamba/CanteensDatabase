package com.example.canteen.Repository

import androidx.lifecycle.LiveData
import com.example.canteen.DAO.OrderDao
import com.example.canteen.Entity.Order

class ListOfOrdersRepository(val orderDao: OrderDao) {
    val allOrders: LiveData<List<Order>> = orderDao.getOrders()

    suspend fun insert(order: Order){
        orderDao.insertOrder(order)
    }
}