package com.example.canteen.Repository

import androidx.lifecycle.LiveData
import com.example.canteen.DAO.MenuDao
import com.example.canteen.Entity.Dish

class BasketRepository(menuDao: MenuDao, dishesId: Set<Int>){
    val dishes: LiveData<List<Dish>> = menuDao.getDish(dishesId)
}
