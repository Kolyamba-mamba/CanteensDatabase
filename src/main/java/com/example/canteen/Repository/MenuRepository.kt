package com.example.canteen.Repository

import androidx.lifecycle.LiveData
import com.example.canteen.DAO.MenuDao
import com.example.canteen.Entity.Dish

class MenuRepository (menuDao: MenuDao, canteenId: Int){
    val allDishes: LiveData<List<Dish>> = menuDao.getDishFromCanteen(canteenId)


//    suspend fun insert(dish: Dish){
//        menuDao.insertDishInMenu(dish)
//    }
}