package com.example.canteen.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.canteen.Entity.Dish

@Dao
interface MenuDao {
    @Query("SELECT * from Dish WHERE Dish.Canteen_Id = :canteenId")
    fun getDishFromCanteen(canteenId: Int):LiveData<List<Dish>>

    @Insert
    suspend fun insertDishInMenu(dish: Dish)
}