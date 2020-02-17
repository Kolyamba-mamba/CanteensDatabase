package com.example.canteen.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.canteen.Entity.Client
import com.example.canteen.Entity.Order

@Dao
interface OrderDao{
    @Query("SELECT * from `Order`")
    fun getOrders(): LiveData<List<Order>>

    @Query("SELECT * FROM `client` LEFT JOIN `order` ON `order`.Client_Id = `client`.Id WHERE `order`.Id = :orderId")
    fun getClientInfo(orderId: Int): LiveData<Client>

    @Insert
    suspend fun insertOrder(order: Order)
}