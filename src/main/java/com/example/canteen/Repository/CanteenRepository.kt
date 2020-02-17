package com.example.canteen.Repository

import androidx.lifecycle.LiveData
import com.example.canteen.DAO.CanteenDao
import com.example.canteen.Entity.Canteen

class CanteenRepository(private val canteenDao: CanteenDao){
  val allCanteen: LiveData<List<Canteen>> = canteenDao.getAllCanteens()


  suspend fun insert(canteen: Canteen){
    canteenDao.insertCanteen(canteen)
  }
}