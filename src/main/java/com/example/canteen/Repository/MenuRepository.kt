package com.example.canteen.Repository

import androidx.lifecycle.LiveData
import com.example.canteen.DAO.MenuDao
import com.example.canteen.Entity.Dish

class MenuRepository (private val menuDao: MenuDao){
    val allDishes: LiveData<List<Dish>> = menuDao.getDishFromCanteen()


    suspend fun insert(dish: Dish){
        menuDao.insertDishInMenu(dish)
    }
}