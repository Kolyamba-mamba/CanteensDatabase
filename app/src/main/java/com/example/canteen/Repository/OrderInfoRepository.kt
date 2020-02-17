package com.example.canteen.Repository

import androidx.lifecycle.LiveData
import com.example.canteen.DAO.OrderDao
import com.example.canteen.Entity.Client

class OrderInfoRepository(orderDao: OrderDao, orderId: Int) {
    val clientInfo: LiveData<Client> = orderDao.getClientInfo(orderId)
}